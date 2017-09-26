package fundacionFRC.modulos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.Bolsa;
import fundacionFRC.beans.Comprador;
import fundacionFRC.beans.Convenio;
import fundacionFRC.beans.DetalleArbolitoVendido;
import fundacionFRC.beans.Estado;
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.beans.HistoricoArbolitoVendido;
import fundacionFRC.beans.HistoricoEstado;
import fundacionFRC.beans.Iva;
import fundacionFRC.beans.Lote;
import fundacionFRC.beans.Personal;
import fundacionFRC.beans.Tarjeta;
import fundacionFRC.beans.Venta;
import fundacionFRC.generales.IConstantes;

public interface IConsultasDAO {

	/**
	 * Obtiene los estados historicos de un arbolito
	 * 
	 * @param aHistoricoEstado
	 * @return
	 * @throws Exception
	 */
	public static List<HistoricoEstado> getHistoricoEstados(HistoricoEstado aHistoricoEstado) throws Exception {
		List<HistoricoEstado> historicos = new ArrayList<HistoricoEstado>();
		List<Object> parametros = new ArrayList<Object>();
		HistoricoEstado historico = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, e.titulo_estado");
			sql.append("  FROM historico_estados a ");
			sql.append("  INNER JOIN estados e ON a.id_estado = e.id");
			sql.append("  WHERE 1=1");

			if (aHistoricoEstado != null && aHistoricoEstado.getHistorico() != null && aHistoricoEstado.getHistorico().getId() != null) {
				sql.append("  AND a.id_historico = ?");
				parametros.add(aHistoricoEstado.getHistorico().getId());
			}

			sql.append("  ORDER BY a.id ");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				historico = new HistoricoEstado();

				// arbolitos
				historico.getEstado().setTituloEstado((String) rs.getObject("titulo_estado"));
				historico.setId((Integer) rs.getObject("id"));
				historico.getHistorico().setId((Integer) rs.getObject("id_historico"));

				historicos.add(historico);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return historicos;

	}

	/**
	 * Obtiene el historico resumido de un usuario
	 * 
	 * @param aHistoricoArbolitoVendido
	 * @return historicos
	 * @throws Exception
	 */
	public static List<HistoricoArbolitoVendido> getHistoricoResumidoUsuario(HistoricoArbolitoVendido aHistoricoArbolitoVendido) throws Exception {
		List<HistoricoArbolitoVendido> historicos = new ArrayList<HistoricoArbolitoVendido>();
		List<Object> parametros = new ArrayList<Object>();
		HistoricoArbolitoVendido historico = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT DISTINCT a.id_arbolito, r.nombre, r.nombre_us, COUNT(*) numero_arbolitos");
			sql.append("  FROM historico_arbolito_vendido a ");
			sql.append("  LEFT  JOIN lotes l ON l.id = a.id_lote ");
			sql.append("  INNER JOIN estados e ON e.id = a.id_estado ");
			sql.append("  INNER JOIN ventas v ON v.id = a.id_venta ");
			sql.append("  LEFT JOIN compradores c ON c.id = v.id_comprador ");
			sql.append("  INNER JOIN arbolitos r ON r.id = a.id_arbolito ");
			sql.append("  WHERE 1=1");

			// si o no provenientes de bolsas
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getIndicativoBolsa() != null && !aHistoricoArbolitoVendido.getIndicativoBolsa().trim().equals("")) {
				sql.append("  AND a.indicativo_bolsa = ?");
				parametros.add(aHistoricoArbolitoVendido.getIndicativoBolsa().trim());
			}

			// ´rpovenientes de bolsa

			// con lote, sin lote, ambos
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getLote() != null && aHistoricoArbolitoVendido.getLote().getNombreLote() != null && !aHistoricoArbolitoVendido.getLote().getNombreLote().trim().equals("")) {

				if (aHistoricoArbolitoVendido.getLote().getNombreLote().equals("-1")) {
					sql.append("  AND a.id_lote IS NULL");

				} else {

					sql.append("  AND l.nombre_lote = ?");
					parametros.add(aHistoricoArbolitoVendido.getLote().getNombreLote().trim());
				}

			}

			// con nombre de arbolito o con placa o sin nada
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular() != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND ( (a.nombre_arbolito IS NOT NULL AND a.nombre_arbolito <> '') OR (a.mensaje_placa IS NOT NULL AND a.mensaje_placa <> '') )");

			}
			// no personalizado, osea sin nombre propio o sin placa personalizada
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular() != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular().equals(IConstantes.NEGACION)) {
				sql.append("  AND NOT( (a.nombre_arbolito IS NOT NULL AND a.nombre_arbolito <> '') OR (a.mensaje_placa IS NOT NULL AND a.mensaje_placa <> '') )");

			}

			// regalado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTregalarlo() != null && aHistoricoArbolitoVendido.getTregalarlo().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND  (a.correo_electronico_regalo IS NOT NULL AND a.correo_electronico_regalo <> '')  ");
			}

			// busca por el correo ya que son los que le regalaron
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getCorreoReceptorRegalo() != null && !aHistoricoArbolitoVendido.getCorreoReceptorRegalo().trim().equals("")) {
				sql.append("  AND UPPER(a.correo_electronico_regalo) = ? ");
				parametros.add(aHistoricoArbolitoVendido.getCorreoReceptorRegalo().trim().toUpperCase());
			}

			// no regalado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTregalarlo() != null && aHistoricoArbolitoVendido.getTregalarlo().equals(IConstantes.NEGACION)) {
				sql.append("  AND  NOT(a.correo_electronico_regalo IS NOT NULL AND a.correo_electronico_regalo <> '')  ");
			}

			// reemplazado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTReemplazado() != null && aHistoricoArbolitoVendido.getTReemplazado().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND  a.id_historico_sup IS NOT NULL  ");
			}
			// no reemplazado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTReemplazado() != null && aHistoricoArbolitoVendido.getTReemplazado().equals(IConstantes.NEGACION)) {
				sql.append("  AND  a.id_historico_sup IS NULL  ");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getEstado() != null && aHistoricoArbolitoVendido.getEstado().getId() != null) {
				sql.append("  AND a.id_estado = ?");
				parametros.add(aHistoricoArbolitoVendido.getEstado().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getId() != null) {
				sql.append("  AND a.id_venta = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion() != null && !aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion().trim().equals("")) {
				sql.append("  AND v.estado_transaccion = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion().trim());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().gettFechaDesde() != null) {

				sql.append("  AND v.fecha_transaccion >= '" + formato.format(aHistoricoArbolitoVendido.getVenta().gettFechaDesde()) + "'");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().gettFechaHasta() != null) {

				sql.append("  AND v.fecha_transaccion <= '" + formato.format(aHistoricoArbolitoVendido.getVenta().gettFechaHasta()) + "'");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getComprador() != null && aHistoricoArbolitoVendido.getVenta().getComprador().getId() != null) {
				sql.append("  AND v.id_comprador = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getComprador().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getComprador() != null && aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto() != null && !aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto().trim().equals("")) {
				sql.append("  AND UPPER(c.nombre_completo) LIKE  ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto().toUpperCase().trim());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getArbolito() != null && aHistoricoArbolitoVendido.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aHistoricoArbolitoVendido.getArbolito().getId());
			}

			sql.append("  GROUP BY a.id_arbolito, r.nombre, r.nombre_us");
			sql.append("  ORDER BY r.nombre, r.nombre_us");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				historico = new HistoricoArbolitoVendido();

				// arbolitos
				historico.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				historico.getArbolito().setNombre((String) rs.getObject("nombre"));
				historico.getArbolito().setNombreUS((String) rs.getObject("nombre_us"));
				historico.getArbolito().setCantidadDisponible(((Long) rs.getObject("numero_arbolitos")).intValue());

				historicos.add(historico);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return historicos;

	}

	/**
	 * Obtiene el historico de un arbolito para realizar transacciones sobre éste.
	 * 
	 * @param aHistoricoArbolitoVendido
	 * @return historicos
	 * @throws Exception
	 */
	public static List<HistoricoArbolitoVendido> getHistoricoArbolito(HistoricoArbolitoVendido aHistoricoArbolitoVendido) throws Exception {
		List<HistoricoArbolitoVendido> historicos = new ArrayList<HistoricoArbolitoVendido>();
		List<Object> parametros = new ArrayList<Object>();
		HistoricoArbolitoVendido historico = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, r.nombre, r.nombre_us, v.fecha_transaccion, c.nombre_completo, e.titulo_estado, e.estado_vigencia, l.nombre_lote, c.correo_electronico, e.permite_personalizacion, l.cantidad_disponible, r.cantidad_disponible disponibilidad_arbolitos");
			sql.append("  FROM historico_arbolito_vendido a ");
			sql.append("  LEFT  JOIN lotes l ON l.id = a.id_lote ");
			sql.append("  INNER JOIN estados e ON e.id = a.id_estado ");
			sql.append("  INNER JOIN ventas v ON v.id = a.id_venta ");
			sql.append("  LEFT JOIN compradores c ON c.id = v.id_comprador ");
			sql.append("  INNER JOIN arbolitos r ON r.id = a.id_arbolito ");
			sql.append("  WHERE 1=1");

			// si o no provenientes de bolsas
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getIndicativoBolsa() != null && !aHistoricoArbolitoVendido.getIndicativoBolsa().trim().equals("")) {
				sql.append("  AND a.indicativo_bolsa = ?");
				parametros.add(aHistoricoArbolitoVendido.getIndicativoBolsa().trim());
			}

			// con lote, sin lote, ambos
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getLote() != null && aHistoricoArbolitoVendido.getLote().getNombreLote() != null && !aHistoricoArbolitoVendido.getLote().getNombreLote().trim().equals("")) {

				if (aHistoricoArbolitoVendido.getLote().getNombreLote().equals("-1")) {
					sql.append("  AND a.id_lote IS NULL");

				} else {

					sql.append("  AND l.nombre_lote = ?");
					parametros.add(aHistoricoArbolitoVendido.getLote().getNombreLote().trim());
				}

			}

			// con nombre de arbolito o con placa o sin nada
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular() != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND ( (a.nombre_arbolito IS NOT NULL AND a.nombre_arbolito <> '') OR (a.mensaje_placa IS NOT NULL AND a.mensaje_placa <> '') )");

			}
			// no personalizado, osea sin nombre propio o sin placa personalizada
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular() != null && aHistoricoArbolitoVendido.getTPlacaNombreParticular().equals(IConstantes.NEGACION)) {
				sql.append("  AND NOT( (a.nombre_arbolito IS NOT NULL AND a.nombre_arbolito <> '') OR (a.mensaje_placa IS NOT NULL AND a.mensaje_placa <> '') )");

			}

			// regalado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTregalarlo() != null && aHistoricoArbolitoVendido.getTregalarlo().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND  (a.correo_electronico_regalo IS NOT NULL AND a.correo_electronico_regalo <> '')  ");
			}

			// busca por el correo ya que son los que le regalaron
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getCorreoReceptorRegalo() != null && !aHistoricoArbolitoVendido.getCorreoReceptorRegalo().trim().equals("")) {
				sql.append("  AND UPPER(a.correo_electronico_regalo) = ? ");
				parametros.add(aHistoricoArbolitoVendido.getCorreoReceptorRegalo().trim().toUpperCase());
			}

			// no regalado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTregalarlo() != null && aHistoricoArbolitoVendido.getTregalarlo().equals(IConstantes.NEGACION)) {
				sql.append("  AND  NOT(a.correo_electronico_regalo IS NOT NULL AND a.correo_electronico_regalo <> '')  ");
			}

			// reemplazado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTReemplazado() != null && aHistoricoArbolitoVendido.getTReemplazado().equals(IConstantes.AFIRMACION)) {
				sql.append("  AND  a.id_historico_sup IS NOT NULL  ");
			}
			// no reemplazado
			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getTReemplazado() != null && aHistoricoArbolitoVendido.getTReemplazado().equals(IConstantes.NEGACION)) {
				sql.append("  AND  a.id_historico_sup IS NULL  ");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getEstado() != null && aHistoricoArbolitoVendido.getEstado().getId() != null) {
				sql.append("  AND a.id_estado = ?");
				parametros.add(aHistoricoArbolitoVendido.getEstado().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getId() != null) {
				sql.append("  AND a.id_venta = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion() != null && !aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion().trim().equals("")) {
				sql.append("  AND v.estado_transaccion = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getEstadoTransaccion().trim());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().gettFechaDesde() != null) {

				sql.append("  AND v.fecha_transaccion >= '" + formato.format(aHistoricoArbolitoVendido.getVenta().gettFechaDesde()) + "'");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().gettFechaHasta() != null) {

				sql.append("  AND v.fecha_transaccion <= '" + formato.format(aHistoricoArbolitoVendido.getVenta().gettFechaHasta()) + "'");
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getComprador() != null && aHistoricoArbolitoVendido.getVenta().getComprador().getId() != null) {
				sql.append("  AND v.id_comprador = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getComprador().getId());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getComprador() != null && aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto() != null && !aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto().trim().equals("")) {
				sql.append("  AND UPPER(c.nombre_completo) LIKE  ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getComprador().getNombreCompleto().toUpperCase().trim());
			}

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getArbolito() != null && aHistoricoArbolitoVendido.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aHistoricoArbolitoVendido.getArbolito().getId());
			}

			sql.append("  ORDER BY v.fecha_transaccion DESC, c.nombre_completo, r.nombre, r.nombre_us, a.numero_interno");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				historico = new HistoricoArbolitoVendido();

				// histórico

				historico.setId((Integer) rs.getObject("id"));
				historico.setCorreoReceptorRegalo((String) rs.getObject("correo_electronico_regalo"));
				historico.setMensajePlaca((String) rs.getObject("mensaje_placa"));
				historico.setNombrePersonalizadoArbolito((String) rs.getObject("nombre_arbolito"));
				historico.setNumeroInterno((Integer) rs.getObject("numero_interno"));

				// compradores
				historico.getVenta().getComprador().setNombreCompleto((String) rs.getObject("nombre_completo"));
				historico.getVenta().getComprador().setCorreoElectronico((String) rs.getObject("correo_electronico"));

				// ventas
				historico.getVenta().setId((Integer) rs.getObject("id_venta"));
				historico.getVenta().setFechaTransaccion((Date) rs.getObject("fecha_transaccion"));

				historico.setHistoricoSuperior((String) rs.getObject("id_historico_sup"));

				// estados
				historico.getEstado().setId((Integer) rs.getObject("id_estado"));
				historico.getEstado().setTituloEstado((String) rs.getObject("titulo_estado"));
				historico.getEstado().setEstadoVigencia((String) rs.getObject("estado_vigencia"));
				historico.getEstado().setPermitePersonalizacion((String) rs.getObject("permite_personalizacion"));

				// arbolitos
				historico.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				historico.getArbolito().setNombre((String) rs.getObject("nombre"));
				historico.getArbolito().setNombreUS((String) rs.getObject("nombre_us"));
				historico.getArbolito().setCantidadDisponible((Integer) rs.getObject("disponibilidad_arbolitos"));

				// lotes
				historico.getLote().setId((Integer) rs.getObject("id_lote"));
				historico.getLote().setNombreLote((String) rs.getObject("nombre_lote"));
				historico.getLote().setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				historicos.add(historico);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return historicos;

	}

	/**
	 * Obtiene el historico de ventas
	 * 
	 * @param aHistoricoArbolitoVendido
	 * @return historicos
	 * @throws Exception
	 */
	public static List<HistoricoArbolitoVendido> getHistoricoVenta(HistoricoArbolitoVendido aHistoricoArbolitoVendido) throws Exception {
		List<HistoricoArbolitoVendido> historicos = new ArrayList<HistoricoArbolitoVendido>();
		List<Object> parametros = new ArrayList<Object>();
		HistoricoArbolitoVendido historico = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, l.cantidad_disponible, l.indicativo_infinito");
			sql.append("  FROM historico_arbolito_vendido a ");
			sql.append("  LEFT JOIN lotes l ON l.id = a.id_lote "); // se_cambio_a_left

			sql.append("  WHERE 1=1 ");
			// sql.append(" WHERE l.indicativo_infinito = 'N'");

			if (aHistoricoArbolitoVendido != null && aHistoricoArbolitoVendido.getVenta() != null && aHistoricoArbolitoVendido.getVenta().getId() != null) {
				sql.append("  AND a.id_venta = ?");
				parametros.add(aHistoricoArbolitoVendido.getVenta().getId());
			}

			sql.append("  ORDER BY a.id");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				historico = new HistoricoArbolitoVendido();

				// histórico

				historico.setId((Integer) rs.getObject("id"));
				historico.setCorreoReceptorRegalo((String) rs.getObject("correo_electronico_regalo"));
				historico.setMensajePlaca((String) rs.getObject("mensaje_placa"));
				historico.setNombrePersonalizadoArbolito((String) rs.getObject("nombre_arbolito"));
				historico.setNumeroInterno((Integer) rs.getObject("numero_interno"));

				// ventas
				historico.getVenta().setId((Integer) rs.getObject("id_venta"));

				// historico.setHistoricoSuperior(rs.getObject(""));

				// estados
				historico.getEstado().setId((Integer) rs.getObject("id_estado"));

				// arbolitos
				historico.getArbolito().setId((Integer) rs.getObject("id_arbolito"));

				// lotes
				historico.getLote().setId((Integer) rs.getObject("id_lote"));
				historico.getLote().setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				historico.getLote().setIndicativoInfinito((String) rs.getObject("indicativo_infinito"));

				historicos.add(historico);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return historicos;

	}

	/**
	 * Obtiene un listado del detalle de la venta
	 * 
	 * @param aDetalleArbolitoVendido
	 * @return detalleVentas
	 * @throws Exception
	 */
	public static List<DetalleArbolitoVendido> getDetalleVentas(DetalleArbolitoVendido aDetalleArbolitoVendido) throws Exception {
		List<DetalleArbolitoVendido> detalleVentas = new ArrayList<DetalleArbolitoVendido>();
		List<Object> parametros = new ArrayList<Object>();
		DetalleArbolitoVendido detalle = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, r.nombre, r.nombre_us, r.cantidad_disponible, r.cantidad_pendiente_pago, v.fecha_transaccion, v.moneda, c.nombre_completo");
			sql.append("  FROM detalle_arbolito_vendido a ");
			sql.append("  INNER JOIN arbolitos r ON a.id_arbolito = r.id ");
			sql.append("  INNER JOIN ventas v ON v.id = a.id_venta ");
			sql.append("  LEFT JOIN compradores c ON c.id = v.id_comprador ");
			sql.append("  WHERE 1=1");

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().getId() != null) {
				sql.append("  AND a.id_venta = ?");
				parametros.add(aDetalleArbolitoVendido.getVenta().getId());
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().getEstadoTransaccion() != null && !aDetalleArbolitoVendido.getVenta().getEstadoTransaccion().trim().equals("")) {
				sql.append("  AND v.estado_transaccion = ?");
				parametros.add(aDetalleArbolitoVendido.getVenta().getEstadoTransaccion().trim());
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().gettFechaDesde() != null) {

				sql.append("  AND v.fecha_transaccion >= '" + formato.format(aDetalleArbolitoVendido.getVenta().gettFechaDesde()) + "'");
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().gettFechaHasta() != null) {

				sql.append("  AND v.fecha_transaccion <= '" + formato.format(aDetalleArbolitoVendido.getVenta().gettFechaHasta()) + "'");
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().getComprador() != null && aDetalleArbolitoVendido.getVenta().getComprador().getId() != null) {
				sql.append("  AND v.id_comprador = ?");
				parametros.add(aDetalleArbolitoVendido.getVenta().getComprador().getId());
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().getMoneda() != null && !aDetalleArbolitoVendido.getVenta().getMoneda().trim().equals("")) {
				sql.append("  AND v.moneda = ?");
				parametros.add(aDetalleArbolitoVendido.getVenta().getMoneda());
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getVenta() != null && aDetalleArbolitoVendido.getVenta().getComprador() != null && aDetalleArbolitoVendido.getVenta().getComprador().getNombreCompleto() != null && !aDetalleArbolitoVendido.getVenta().getComprador().getNombreCompleto().trim().equals("")) {
				sql.append("  AND UPPER(c.nombre_completo) LIKE  ?");
				parametros.add(aDetalleArbolitoVendido.getVenta().getComprador().getNombreCompleto().toUpperCase().trim());
			}

			if (aDetalleArbolitoVendido != null && aDetalleArbolitoVendido.getArbolito() != null && aDetalleArbolitoVendido.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aDetalleArbolitoVendido.getArbolito().getId());
			}

			sql.append("  ORDER BY v.fecha_transaccion DESC, c.nombre_completo, r.nombre, r.nombre_us");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				detalle = new DetalleArbolitoVendido();

				detalle.setId((Integer) rs.getObject("id"));
				detalle.setCantidadArbolitos((Integer) rs.getObject("cantidad_arbolitos"));
				detalle.setPorcentajeIvaAplicado((BigDecimal) rs.getObject("porcentaje_iva_aplicado"));
				detalle.setValorIva((BigDecimal) rs.getObject("valor_iva"));
				detalle.setValorTotal((BigDecimal) rs.getObject("valor_total"));
				detalle.setValorTotalConIva((BigDecimal) rs.getObject("valor_total_con_iva"));
				detalle.setNumeroArbolesBolsa((Integer) rs.getObject("numero_arboles_bolsa"));

				// arbolitos
				detalle.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				detalle.getArbolito().setNombre((String) rs.getObject("nombre"));
				detalle.getArbolito().setNombreUS((String) rs.getObject("nombre_us"));
				detalle.getArbolito().setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				detalle.getArbolito().setCantidadPendientePago((Integer) rs.getObject("cantidad_pendiente_pago"));

				// ventas
				detalle.getVenta().setId((Integer) rs.getObject("id_venta"));
				detalle.getVenta().setFechaTransaccion((Date) rs.getObject("fecha_transaccion"));
				detalle.getVenta().setMoneda((String) rs.getObject("moneda"));

				// comnpradores
				detalle.getVenta().getComprador().setNombreCompleto((String) rs.getObject("nombre_completo"));

				detalleVentas.add(detalle);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return detalleVentas;

	}

	/**
	 * Obtiene un listado de las ventas
	 * 
	 * @param aVenta
	 * @return ventas
	 * @throws Exception
	 */
	public static List<Venta> getVentas(Venta aVenta) throws Exception {
		List<Venta> ventas = new ArrayList<Venta>();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		List<Object> parametros = new ArrayList<Object>();
		Venta venta = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		String operadorTransformado = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, c.nombre_completo, c.correo_electronico, t.algoritmo, co.nombre nombre_convenio, t.porcentaje_comision_aplicado, a.idioma_transaccion");
			sql.append("  FROM ventas a ");
			sql.append("  LEFT JOIN compradores c ON c.id = a.id_comprador ");
			sql.append("  LEFT JOIN tarjetas t ON a.id_tarjeta = t.id ");
			sql.append("  LEFT JOIN convenios co ON t.id_convenio = co.id ");
			sql.append("  WHERE 1=1");

			if (aVenta != null && aVenta.getIdTransaccion() != null && !aVenta.getIdTransaccion().trim().equals("")) {
				sql.append("  AND a.id_transaccion = ?");
				parametros.add(aVenta.getIdTransaccion().trim());
			}

			if (aVenta != null && aVenta.getId() != null) {
				sql.append("  AND a.id = ?");
				parametros.add(aVenta.getId());
			}

			if (aVenta != null && aVenta.getEstadoTransaccion() != null && !aVenta.getEstadoTransaccion().trim().equals("")) {
				sql.append("  AND a.estado_transaccion = ?");
				parametros.add(aVenta.getEstadoTransaccion());
			}

			if (aVenta != null && aVenta.gettFechaDesde() != null) {

				sql.append("  AND a.fecha_transaccion >= '" + formato.format(aVenta.gettFechaDesde()) + "'");
			}

			if (aVenta != null && aVenta.gettFechaHasta() != null) {

				sql.append("  AND a.fecha_transaccion <= '" + formato.format(aVenta.gettFechaHasta()) + "'");
			}

			if (aVenta != null && aVenta.getComprador() != null && aVenta.getComprador().getId() != null) {
				sql.append("  AND a.id_comprador = ?");
				parametros.add(aVenta.getComprador().getId());
			}

			// mira si posee o no tarjeta
			// 1:si
			// 0:no
			// null ni lo valida
			if (aVenta != null && aVenta.getTarjeta() != null && aVenta.getTarjeta().getId() != null) {
				if (aVenta.getTarjeta().getId().intValue() == 1) {
					sql.append("  AND a.id_tarjeta IS NOT NULL");
				} else {
					sql.append("  AND a.id_tarjeta IS NULL");
				}
			}

			// convenios
			if (aVenta != null && aVenta.getTarjeta() != null && aVenta.getTarjeta().getConvenio() != null && aVenta.getTarjeta().getConvenio().getId() != null) {
				sql.append("  AND co.id = ?");
				parametros.add(aVenta.getTarjeta().getConvenio().getId());
			}

			if (aVenta != null && aVenta.getMoneda() != null && !aVenta.getMoneda().trim().equals("")) {
				sql.append("  AND a.moneda = ?");
				parametros.add(aVenta.getMoneda());
			}

			if (aVenta != null && aVenta.gettOperadorConsulta() != null && !aVenta.gettOperadorConsulta().trim().equals("") && aVenta.getCantidadTotalVenta() != null) {

				if (aVenta.gettOperadorConsulta().equals("MENOR_IGUAL")) {
					operadorTransformado = "<=";
				} else if (aVenta.gettOperadorConsulta().equals("MAYOR_IGUAL")) {
					operadorTransformado = ">=";
				} else {
					operadorTransformado = "=";
				}

				sql.append("  AND a.cantidad_total_venta " + operadorTransformado + " ?");
				parametros.add(aVenta.getCantidadTotalVenta());
			}

			if (aVenta != null && aVenta.gettOperadorVentas() != null && !aVenta.gettOperadorVentas().trim().equals("") && aVenta.getValorTotalConIva() != null) {

				if (aVenta.gettOperadorVentas().equals("MENOR_IGUAL")) {
					operadorTransformado = "<=";
				} else if (aVenta.gettOperadorVentas().equals("MAYOR_IGUAL")) {
					operadorTransformado = ">=";
				} else {
					operadorTransformado = "=";
				}

				sql.append("  AND a.valor_total_con_iva " + operadorTransformado + " ?");
				parametros.add(aVenta.getValorTotalConIva());
			}

			if (aVenta != null && aVenta.getComprador() != null && aVenta.getComprador().getNombreCompleto() != null && !aVenta.getComprador().getNombreCompleto().trim().equals("")) {
				sql.append("  AND UPPER(c.nombre_completo) LIKE  ?");
				parametros.add(aVenta.getComprador().getNombreCompleto().toUpperCase().trim());
			}

			sql.append("  ORDER BY fecha_transaccion DESC, hora_transaccion DESC");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				venta = new Venta();
				venta.setId((Integer) rs.getObject("id"));
				venta.setIdTransaccion((String) rs.getObject("id_transaccion"));
				venta.setCantidadTotalVenta((Integer) rs.getObject("cantidad_total_venta"));
				venta.setIdiomaTransaccion((String) rs.getObject("idioma_transaccion"));
				venta.getComprador().setId((Integer) rs.getObject("id_comprador"));
				venta.getComprador().setNombreCompleto((String) rs.getObject("nombre_completo"));
				venta.getComprador().setCorreoElectronico((String) rs.getObject("correo_electronico"));
				venta.setEstadoTransaccion((String) rs.getObject("estado_transaccion"));
				venta.setFechaTransaccion((Date) rs.getObject("fecha_transaccion"));
				venta.setHoraTransaccion((Date) rs.getObject("hora_transaccion"));
				venta.setMoneda((String) rs.getObject("moneda"));
				venta.setValorTotalConIva((BigDecimal) rs.getObject("valor_total_con_iva"));
				venta.setValorTotalIva((BigDecimal) rs.getObject("valor_total_iva"));
				venta.setValorTotalVenta((BigDecimal) rs.getObject("valor_total_venta"));
				venta.setGananaciaConvenio((BigDecimal) rs.getObject("ganancia_convenio"));
				venta.getTarjeta().setAlgoritmo((String) rs.getObject("algoritmo"));
				venta.getTarjeta().getConvenio().setNombre((String) rs.getObject("nombre_convenio"));
				venta.getTarjeta().setPorcentajeComisionAplicado((BigDecimal) rs.getObject("porcentaje_comision_aplicado"));

				ventas.add(venta);

			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return ventas;

	}

	/**
	 * Obtiene las fotos de un arbolito de acuerdo a los parámetros
	 * 
	 * @param aFotoArbolito
	 * @return fotos
	 * @throws Exception
	 */
	public static List<FotoArbolito> getFotosArbolitos(FotoArbolito aFotoArbolito) throws Exception {
		List<FotoArbolito> fotos = new ArrayList<FotoArbolito>();
		List<Object> parametros = new ArrayList<Object>();
		FotoArbolito fotoArbolito = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT f.id, f.titulo, f.id_arbolito, f.id_historico_arbolito, f.id_lote, encode(foto::bytea, 'base64') foto_decodificada");
			// sql.append(" FROM fotos_arbolitos f ");

			sql.append("  FROM fotos_arbolitos f ");

			sql.append("  WHERE 1=1 ");

			if (aFotoArbolito != null && aFotoArbolito.getArbolito() != null && aFotoArbolito.getArbolito().getId() != null) {
				sql.append(" AND f.id_arbolito = ? ");
				parametros.add(aFotoArbolito.getArbolito().getId());
			}

			if (aFotoArbolito != null && aFotoArbolito.getLote() != null && aFotoArbolito.getLote().getId() != null) {
				sql.append(" AND f.id_lote = ? ");
				parametros.add(aFotoArbolito.getLote().getId());
			}

			if (aFotoArbolito != null && aFotoArbolito.getHistoricoArbolitoVendido() != null && aFotoArbolito.getHistoricoArbolitoVendido().getId() != null) {
				sql.append(" AND f.id_historico_arbolito = ? ");
				parametros.add(aFotoArbolito.getHistoricoArbolitoVendido().getId());
			}

			sql.append("  ORDER BY f.id DESC, f.titulo");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				fotoArbolito = new FotoArbolito();

				fotoArbolito.setId((Integer) rs.getObject("id"));
				fotoArbolito.setTitulo((String) rs.getObject("titulo"));

				// ya no la reemplazmos por demorada
				// fotoArbolito.setFoto((byte[]) rs.getObject("foto"));

				fotoArbolito.setFotoDecofificada((String) rs.getObject("foto_decodificada"));
				fotoArbolito.setFotoDecofificada(fotoArbolito.getFotoDecofificada());

				fotos.add(fotoArbolito);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return fotos;

	}

	/**
	 * Obtiene disponibilidad de un lote. No cerramos la conexión porque la maneja
	 * el papá
	 * 
	 * @param aArbolito
	 * @return lotes
	 * @throws Exception
	 */
	public static List<Lote> getLotesArbolesDisponibles(Conexion aConexion, Arbolito aArbolito) throws Exception {
		List<Lote> lotes = new ArrayList<Lote>();
		List<Object> parametros = new ArrayList<Object>();
		Lote lote = null;

		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*");
			sql.append("  FROM lotes a ");
			sql.append("  WHERE a.id_arbolito = ?");
			sql.append("  AND a.cantidad_disponible > 0");
			sql.append("  AND a.indicativo_infinito = 'N'");
			sql.append("  UNION ALL ");
			sql.append("  SELECT a.*");
			sql.append("  FROM lotes a ");
			sql.append("  WHERE a.id_arbolito = ?");
			sql.append("  AND a.indicativo_infinito = 'S' ");
			sql.append("  ORDER BY indicativo_infinito, nombre_lote  ");
			sql.append("  LIMIT 1  ");

			parametros.add(aArbolito.getId());
			parametros.add(aArbolito.getId());

			rs = aConexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				lote = new Lote();
				lote.setId((Integer) rs.getObject("id"));
				lote.setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				lote.setCantidadVendida((Integer) rs.getObject("cantidad_vendida"));
				lote.setDescripcionLote(rs.getString("descripcion_lote"));
				lote.setIndicativoInfinito((String) rs.getObject("indicativo_infinito"));
				lote.setNombreLote((String) rs.getObject("nombre_lote"));

				// arbolitos
				lote.getArbolito().setId((Integer) rs.getObject("id_arbolito"));

				lotes.add(lote);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			// la cierra el papá
			// conexion.cerrarConexion();

		}
		return lotes;

	}

	/**
	 * Obtiene un listado de lotes discriminado por nombre
	 * 
	 * @param aLote
	 * @return lotes
	 * @throws Exception
	 */
	public static List<Lote> getLotesDiscriminados(Lote aLote) throws Exception {
		List<Lote> lotes = new ArrayList<Lote>();
		Lote lote = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT DISTINCT TRIM(a.nombre_lote) nombre_lote");
			sql.append("  FROM lotes a ");
			sql.append("  ORDER BY nombre_lote");

			rs = conexion.consultarBD(sql.toString(), null);

			while (rs.next()) {

				lote = new Lote();
				lote.setNombreLote((String) rs.getObject("nombre_lote"));

				lotes.add(lote);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return lotes;

	}

	/**
	 * Obtiene un listado de lotes sobr euna misma transacción
	 * 
	 * @param aLote
	 * @return lotes
	 * @throws Exception
	 */
	public static List<Lote> getLotes(Lote aLote, Conexion aConexion) throws Exception {
		List<Lote> lotes = new ArrayList<Lote>();
		List<Object> parametros = new ArrayList<Object>();
		Lote lote = null;
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, r.estado_vigencia, r.nombre");
			sql.append("  FROM lotes a ");
			sql.append("  INNER JOIN arbolitos r ON a.id_arbolito = r.id");
			sql.append("  WHERE 1=1");

			if (aLote != null && aLote.getArbolito() != null && aLote.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aLote.getArbolito().getId());
			}

			if (aLote != null && aLote.getId() != null) {
				sql.append("  AND a.id = ?");
				parametros.add(aLote.getId());

			}

			if (aLote != null && aLote.getNombreLote() != null && !aLote.getNombreLote().trim().equals("")) {
				sql.append("  AND a.nombre_lote = ?");
				parametros.add(aLote.getNombreLote().trim());

			}

			sql.append("  ORDER BY a.nombre_lote");

			rs = aConexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				lote = new Lote();
				lote.setId((Integer) rs.getObject("id"));
				lote.setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				lote.setCantidadVendida((Integer) rs.getObject("cantidad_vendida"));
				lote.setDescripcionLote(rs.getString("descripcion_lote"));
				lote.setIndicativoInfinito((String) rs.getObject("indicativo_infinito"));
				lote.setNombreLote((String) rs.getObject("nombre_lote"));

				// arbolitos
				lote.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				lote.getArbolito().setEstadoVigencia((String) rs.getObject("estado_vigencia"));
				lote.getArbolito().setNombre((String) rs.getObject("nombre"));

				lotes.add(lote);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}

		}
		return lotes;

	}

	/**
	 * Obtiene un listado de lotes
	 * 
	 * @param aLote
	 * @return lotes
	 * @throws Exception
	 */
	public static List<Lote> getLotes(Lote aLote) throws Exception {
		List<Lote> lotes = new ArrayList<Lote>();
		List<Object> parametros = new ArrayList<Object>();
		Lote lote = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, r.estado_vigencia, r.nombre");
			sql.append("  FROM lotes a ");
			sql.append("  INNER JOIN arbolitos r ON a.id_arbolito = r.id");
			sql.append("  WHERE 1=1");

			if (aLote != null && aLote.getArbolito() != null && aLote.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aLote.getArbolito().getId());
			}

			sql.append("  ORDER BY a.nombre_lote");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				lote = new Lote();
				lote.setId((Integer) rs.getObject("id"));
				lote.setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				lote.setCantidadVendida((Integer) rs.getObject("cantidad_vendida"));
				lote.setDescripcionLote(rs.getString("descripcion_lote"));
				lote.setIndicativoInfinito((String) rs.getObject("indicativo_infinito"));
				lote.setNombreLote((String) rs.getObject("nombre_lote"));

				// arbolitos
				lote.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				lote.getArbolito().setEstadoVigencia((String) rs.getObject("estado_vigencia"));
				lote.getArbolito().setNombre((String) rs.getObject("nombre"));

				lotes.add(lote);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return lotes;

	}

	/**
	 * Obtiene las bolsas de arbolitos las cuales están disponibles
	 * 
	 * @param aBolsa
	 * @return bolsas
	 * @throws Exception
	 */
	public static List<Bolsa> getBolsas(Bolsa aBolsa) throws Exception {
		List<Bolsa> bolsas = new ArrayList<Bolsa>();
		List<Object> parametros = new ArrayList<Object>();
		Bolsa bolsa = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, i.nombre nombre_iva, i.valor_iva, ar.nombre nombre_arbolito_es, ar.nombre_us, ar.descripcion, ar.descripcion_us");
			sql.append("  FROM bolsas a ");
			sql.append("  INNER JOIN iva i ON a.id_iva = i.id");
			sql.append("  INNER JOIN arbolitos ar ON ar.id = a.id_arbolito");
			sql.append("  WHERE 1=1");

			if (aBolsa != null && aBolsa.getId() != null) {
				sql.append("  AND a.id = ?");
				parametros.add(aBolsa.getId());
			}

			if (aBolsa != null && aBolsa.getEstadoVigencia() != null && !aBolsa.getEstadoVigencia().equals("")) {
				sql.append("  AND a.estado_vigencia = ?");
				parametros.add(aBolsa.getEstadoVigencia());
			}

			if (aBolsa != null && aBolsa.getIva() != null && aBolsa.getIva().getId() != null) {
				sql.append("  AND a.id_iva = ?");
				parametros.add(aBolsa.getIva().getId());
			}

			if (aBolsa != null && aBolsa.getArbolito() != null && aBolsa.getArbolito().getId() != null) {
				sql.append("  AND a.id_arbolito = ?");
				parametros.add(aBolsa.getArbolito().getId());
			}

			if (aBolsa != null && aBolsa.getCantidadDisponible() != null) {
				sql.append("  AND a.cantidad = ?");
				parametros.add(aBolsa.getCantidadDisponible());
			}

			sql.append("  ORDER BY nombre_arbolito_es, ar.nombre_us");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				bolsa = new Bolsa();

				// arbolitos

				bolsa.setId((Integer) rs.getObject("id"));
				bolsa.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				bolsa.getArbolito().setNombre((String) rs.getObject("nombre_arbolito_es"));
				bolsa.getArbolito().setNombreUS((String) rs.getObject("nombre_us"));

				bolsa.getArbolito().setDescripcion((String) rs.getObject("descripcion"));
				bolsa.getArbolito().setDescripcionUS((String) rs.getObject("descripcion_us"));

				bolsa.setCantidadDisponible((Integer) rs.getObject("cantidad"));

				bolsa.setCantidadVendida((Integer) rs.getObject("bolsas_vendidas"));

				bolsa.setEstadoVigencia((String) rs.getObject("estado_vigencia"));

				bolsa.setPrecioVentaPesos((BigDecimal) rs.getObject("precio_cop_sin_iva"));
				bolsa.setPrecioVentaUS((BigDecimal) rs.getObject("precio_us_sin_iva"));
				bolsa.setIvaUs((BigDecimal) rs.getObject("valor_iva_us"));
				bolsa.setIvaPesos((BigDecimal) rs.getObject("valor_iva_cop"));
				bolsa.setPrecioVentaPesosConIva((BigDecimal) rs.getObject("precio_cop_con_iva"));
				bolsa.setPrecioVentaUSConIva((BigDecimal) rs.getObject("precio_us_con_iva"));

				// iva
				bolsa.getIva().setId((Integer) rs.getObject("id_iva"));
				bolsa.getIva().setNombre((String) rs.getObject("nombre_iva"));
				bolsa.getIva().setValorIva((BigDecimal) rs.getObject("valor_iva"));

				bolsas.add(bolsa);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return bolsas;

	}

	/**
	 * Obtiene los arbolitos creados
	 * 
	 * @param aArbolito
	 * @return arbolitos
	 * @throws Exception
	 */
	public static List<Arbolito> getArbolitos(Arbolito aArbolito) throws Exception {
		List<Arbolito> arbolitos = new ArrayList<Arbolito>();
		List<Object> parametros = new ArrayList<Object>();
		Arbolito arbolito = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT a.*, i.nombre nombre_iva, i.valor_iva");
			sql.append("  FROM arbolitos a ");
			sql.append("  INNER JOIN iva i ON a.id_iva = i.id");
			sql.append("  WHERE 1=1");

			if (aArbolito != null && aArbolito.getId() != null) {
				sql.append("  AND a.id = ?");
				parametros.add(aArbolito.getId());
			}

			if (aArbolito != null && aArbolito.getEstadoVigencia() != null && !aArbolito.getEstadoVigencia().equals("")) {
				sql.append("  AND a.estado_vigencia = ?");
				parametros.add(aArbolito.getEstadoVigencia());
			}

			if (aArbolito != null && aArbolito.getIva() != null && aArbolito.getIva().getId() != null) {
				sql.append("  AND a.id_iva = ?");
				parametros.add(aArbolito.getIva().getId());
			}

			sql.append("  ORDER BY a.nombre");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				arbolito = new Arbolito();

				// arbolitos
				arbolito.setId((Integer) rs.getObject("id"));
				arbolito.setNombre((String) rs.getObject("nombre"));
				arbolito.setNombreUS((String) rs.getObject("nombre_us"));
				arbolito.setDescripcion(rs.getString("descripcion"));
				arbolito.setDescripcionUS(rs.getString("descripcion_us"));
				arbolito.setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				arbolito.setCantidadUsadaReemplazos((Integer) rs.getObject("cantidad_usada_reemplazos"));
				arbolito.setCantidadVendida((Integer) rs.getObject("cantidad_vendida"));
				arbolito.setCantidadPendientePago((Integer) rs.getObject("cantidad_pendiente_pago"));

				arbolito.setEstadoVigencia((String) rs.getObject("estado_vigencia"));

				arbolito.setPrecioVentaPesos((BigDecimal) rs.getObject("precio_cop_sin_iva"));
				arbolito.setPrecioVentaUS((BigDecimal) rs.getObject("precio_us_sin_iva"));
				arbolito.setIvaUs((BigDecimal) rs.getObject("valor_iva_us"));
				arbolito.setIvaPesos((BigDecimal) rs.getObject("valor_iva_cop"));
				arbolito.setPrecioVentaPesosConIva((BigDecimal) rs.getObject("precio_cop_con_iva"));
				arbolito.setPrecioVentaUSConIva((BigDecimal) rs.getObject("precio_us_con_iva"));

				// iva
				arbolito.getIva().setId((Integer) rs.getObject("id_iva"));
				arbolito.getIva().setNombre((String) rs.getObject("nombre_iva"));
				arbolito.getIva().setValorIva((BigDecimal) rs.getObject("valor_iva"));

				arbolitos.add(arbolito);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return arbolitos;

	}

	/**
	 * Obtiene un comprador de acuerdo a los datos suministrados para una sarta
	 * 
	 * @param aComprador
	 * @return compradores
	 * @throws Exception
	 */
	public static List<Comprador> getCompradoresSarta(Comprador aComprador) throws Exception {
		List<Comprador> compradores = new ArrayList<Comprador>();
		List<Object> parametros = new ArrayList<Object>();
		Comprador comprador = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT *");
			sql.append("  FROM compradores WHERE 1=1");

			if (aComprador != null && aComprador.gettCorreoConsulta() != null && !aComprador.gettCorreoConsulta().trim().equals("")) {
				sql.append(" AND  LOWER(correo_electronico) LIKE ?");
				parametros.add(aComprador.gettCorreoConsulta().trim().toLowerCase());
			}

			if (aComprador != null && aComprador.getNombreCompleto() != null && !aComprador.getNombreCompleto().trim().equals("")) {
				sql.append(" AND  LOWER(nombre_completo) LIKE ?");
				parametros.add(aComprador.getNombreCompleto().trim());
			}

			sql.append("  ORDER BY nombre_completo");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {
				comprador = new Comprador();

				comprador.setId((Integer) rs.getObject("id"));
				comprador.setNombreCompleto((String) rs.getObject("nombre_completo"));
				comprador.setClave((String) rs.getObject("clave"));
				comprador.setCorreoElectronico((String) rs.getObject("correo_electronico"));
				comprador.setIdCompradorDonador((Integer) rs.getObject("id_comprador_donador"));
				compradores.add(comprador);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return compradores;

	}

	/**
	 * Obtiene un comprador de acuerdo a los datos suministrados
	 * 
	 * @param aComprador
	 * @return compradores
	 * @throws Exception
	 */
	public static List<Comprador> getCompradores(Comprador aComprador) throws Exception {
		List<Comprador> compradores = new ArrayList<Comprador>();
		List<Object> parametros = new ArrayList<Object>();
		Comprador comprador = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT *");
			sql.append("  FROM compradores WHERE 1=1");

			if (aComprador != null && aComprador.getCorreoElectronico() != null && !aComprador.getCorreoElectronico().trim().equals("")) {
				sql.append(" AND  correo_electronico = ?");
				parametros.add(aComprador.getCorreoElectronico().trim().toLowerCase());
			}

			if (aComprador != null && aComprador.getClave() != null && !aComprador.getClave().trim().equals("")) {
				sql.append(" AND  clave = ?");
				parametros.add(aComprador.getClave().trim());
			}

			sql.append("  ORDER BY nombre_completo");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {
				comprador = new Comprador();

				comprador.setId((Integer) rs.getObject("id"));
				comprador.setNombreCompleto((String) rs.getObject("nombre_completo"));
				comprador.setClave((String) rs.getObject("clave"));
				comprador.setCorreoElectronico((String) rs.getObject("correo_electronico"));
				comprador.setIdCompradorDonador((Integer) rs.getObject("id_comprador_donador"));
				compradores.add(comprador);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return compradores;

	}

	/**
	 * Obtiene un listado de administradores del software
	 * 
	 * @param aPersonal
	 * @return administradores
	 * @throws Exception
	 */
	public static List<Personal> getAdministradores(Personal aPersonal) throws Exception {
		List<Personal> administradores = new ArrayList<Personal>();
		List<Object> prametros = new ArrayList<Object>();
		Personal administrador = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT *");
			sql.append("  FROM personal p");
			sql.append("  WHERE 1=1 ");

			if (aPersonal != null && aPersonal.getCorreoElectronico() != null && !aPersonal.getCorreoElectronico().trim().equals("")) {
				sql.append("  AND UPPER(p.correo_electronico) = ?");
				prametros.add(aPersonal.getCorreoElectronico().trim().toUpperCase());
			}

			if (aPersonal != null && aPersonal.getClave() != null && !aPersonal.getClave().trim().equals("")) {
				sql.append("  AND p.clave = ?");
				prametros.add(aPersonal.getClave().trim());
			}

			if (aPersonal != null && aPersonal.getEstadoVigencia() != null && !aPersonal.getEstadoVigencia().trim().equals("")) {
				sql.append("  AND p.estado_vigencia = ?");
				prametros.add(aPersonal.getEstadoVigencia().trim());
			}

			sql.append("  ORDER BY nombres, apellidos");

			rs = conexion.consultarBD(sql.toString(), prametros);

			while (rs.next()) {
				administrador = new Personal();
				administrador.setId((Integer) rs.getObject("id"));
				administrador.setNombres((String) rs.getObject("nombres"));
				administrador.setApellidos((String) rs.getObject("apellidos"));
				administrador.setCorreoElectronico((String) rs.getObject("correo_electronico"));
				administrador.setClave((String) rs.getObject("clave"));
				administrador.setEstadoVigencia((String) rs.getObject("estado_vigencia"));
				administrador.setTipoAdministracion((String) rs.getObject("tipo_administracion"));
				administradores.add(administrador);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return administradores;

	}

	/**
	 * Obtiene un listado de los estados de los arbolitos
	 * 
	 * @param aEstado
	 * @return estados
	 * @throws Exception
	 */
	public static List<Estado> getEstados(Estado aEstado) throws Exception {
		List<Estado> estados = new ArrayList<Estado>();
		List<Object> parametros = new ArrayList<Object>();
		Estado estado = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT *");
			sql.append("  FROM estados WHERE 1=1");

			if (aEstado != null && aEstado.getEstadoInicial() != null && !aEstado.getEstadoInicial().trim().equals("")) {
				sql.append("  AND estado_inicial = ?");
				parametros.add(aEstado.getEstadoInicial());

			}

			if (aEstado != null && aEstado.getEstadoVigencia() != null && !aEstado.getEstadoVigencia().trim().equals("")) {
				sql.append("  AND estado_vigencia = ?");
				parametros.add(aEstado.getEstadoVigencia());

			}

			sql.append("  ORDER BY titulo_estado");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {
				estado = new Estado();
				estado.setId((Integer) rs.getObject("id"));
				estado.setTituloEstado((String) rs.getObject("titulo_estado"));
				estado.setEstadoVigencia((String) rs.getObject("estado_vigencia"));
				estado.setEstadoInicial((String) rs.getObject("estado_inicial"));
				estado.setPermitePersonalizacion((String) rs.getObject("permite_personalizacion"));

				estados.add(estado);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return estados;

	}

	/**
	 * Obtiene los registros de convenios
	 * 
	 * @param aConvenio
	 * @return convenios
	 * @throws Exception
	 */
	public static List<Convenio> getConvenios(Convenio aConvenio) throws Exception {
		List<Convenio> convenios = new ArrayList<Convenio>();
		List<Object> parametros = new ArrayList<Object>();
		Convenio convenio = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT c.*, i.valor_iva");
			sql.append("  FROM convenios c");
			sql.append("  INNER JOIN iva i ON  i.id = c.id_comision");
			sql.append("  WHERE 1=1 ");

			if (aConvenio != null && aConvenio.getId() != null) {
				sql.append(" AND c.id = ? ");
				parametros.add(aConvenio.getId());
			}

			sql.append("  ORDER BY c.nombre");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {

				convenio = new Convenio();
				convenio.setId((Integer) rs.getObject("id"));
				convenio.setNombre((String) rs.getObject("nombre"));
				convenio.setTelefonos((String) rs.getObject("telefonos"));
				convenio.setEncargado((String) rs.getObject("encargado"));

				convenio.getComision().setId((Integer) rs.getObject("id_comision"));
				convenio.getComision().setValorIva((BigDecimal) rs.getObject("valor_iva"));

				convenios.add(convenio);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return convenios;

	}

	/**
	 * Obtiene los registros de iva de acuerdo a los parámetros especificados
	 * 
	 * @param aIva
	 * @return ivas
	 * @throws Exception
	 */
	public static List<Iva> getIvas(Iva aIva) throws Exception {
		List<Iva> ivas = new ArrayList<Iva>();
		List<Object> parametros = new ArrayList<Object>();
		Iva iva = null;
		Conexion conexion = new Conexion();
		ResultSet rs = null;
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT *");
			sql.append("  FROM iva ");
			sql.append("  WHERE 1=1 ");

			if (aIva != null && aIva.getId() != null) {
				sql.append(" AND id = ? ");
				parametros.add(aIva.getId());
			}

			sql.append("  ORDER BY valor_iva");

			rs = conexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {
				iva = new Iva();
				iva.setId((Integer) rs.getObject("id"));
				iva.setNombre((String) rs.getObject("nombre"));
				iva.setValorIva((BigDecimal) rs.getObject("valor_iva"));
				ivas.add(iva);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}
			conexion.cerrarConexion();

		}
		return ivas;

	}

	/**
	 * Obtiene las tarjetas de acuerdo a ciertos criterios
	 * 
	 * @param aConexion
	 * @param aTarjeta
	 * @return tarjetas
	 * @throws Exception
	 */
	public static List<Tarjeta> getTarjetas(Conexion aConexion, Tarjeta aTarjeta) throws Exception {
		List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		List<Object> parametros = new ArrayList<Object>();
		Tarjeta tarjeta = null;
	//	Conexion conexion = new Conexion();
		ResultSet rs = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {

			StringBuilder sql = new StringBuilder();
			sql.append("  SELECT t.*, v.moneda, v.valor_total_con_iva, a.nombre, a.nombre_us, a.cantidad_disponible, c.nombre nombre_convenio, v.id id_venta");
			sql.append("  FROM tarjetas t");
			sql.append("  INNER JOIN ventas v ON t.id = v.id_tarjeta");
			sql.append("  INNER JOIN convenios c ON t.id_convenio = c.id");
			sql.append("  INNER JOIN arbolitos a ON t.id_arbolito = a.id");
			sql.append("  WHERE 1=1 ");

			if (aTarjeta != null && aTarjeta.getId() != null) {
				sql.append(" AND t.id = ? ");
				parametros.add(aTarjeta.getId());
			}

			if (aTarjeta != null && aTarjeta.getAlgoritmo() != null && !aTarjeta.getAlgoritmo().equals("")) {
				sql.append(" AND t.algoritmo = ? ");
				parametros.add(aTarjeta.getAlgoritmo().trim());
			}

			if (aTarjeta != null && aTarjeta.gettFechaDesde() != null) {

				sql.append("  AND t.fecha_registro >= '" + formato.format(aTarjeta.gettFechaDesde()) + "'");
			}

			if (aTarjeta != null && aTarjeta.gettFechaHasta() != null) {

				sql.append("  AND t.fecha_registro <= '" + formato.format(aTarjeta.gettFechaHasta()) + "'");
			}

			if (aTarjeta != null && aTarjeta.getConvenio() != null && aTarjeta.getConvenio().getId() != null) {

				sql.append(" AND t.id_convenio = ? ");
				parametros.add(aTarjeta.getConvenio().getId());
			}

			if (aTarjeta != null && aTarjeta.getArbolito() != null && aTarjeta.getArbolito().getId() != null) {

				sql.append(" AND t.id_arbolito = ? ");
				parametros.add(aTarjeta.getArbolito().getId());
			}

			if (aTarjeta != null && aTarjeta.getUsada() != null && !aTarjeta.getUsada().equals("")) {

				sql.append(" AND t.usada = ? ");
				parametros.add(aTarjeta.getUsada());
			}

			if (aTarjeta != null && aTarjeta.gettVenta() != null && aTarjeta.gettVenta().getMoneda() != null && !aTarjeta.gettVenta().getMoneda().equals("")) {

				sql.append(" AND v.moneda = ? ");
				parametros.add(aTarjeta.gettVenta().getMoneda());
			}

			sql.append("  ORDER BY fecha_registro DESC");

			rs = aConexion.consultarBD(sql.toString(), parametros);

			while (rs.next()) {
				tarjeta = new Tarjeta();
				tarjeta.setId((Integer) rs.getObject("id"));
				tarjeta.setPorcentajeComisionAplicado((BigDecimal) rs.getObject("porcentaje_comision_aplicado"));
				tarjeta.setUsada((String) rs.getObject("usada"));
				tarjeta.setAlgoritmo((String) rs.getObject("algoritmo"));
				tarjeta.setIdiomaTarjeta((String) rs.getObject("idioma_tarjeta"));
				tarjeta.setFechaRegistro((Date) rs.getObject("fecha_registro"));

				tarjeta.settVenta(new Venta());
				tarjeta.gettVenta().setMoneda((String) rs.getObject("moneda"));
				tarjeta.gettVenta().setValorTotalConIva((BigDecimal) rs.getObject("valor_total_con_iva"));
				tarjeta.gettVenta().setId((Integer) rs.getObject("id_venta"));
				tarjeta.getArbolito().setNombre((String) rs.getObject("nombre"));
				tarjeta.getArbolito().setNombreUS((String) rs.getObject("nombre_us"));
				tarjeta.getArbolito().setCantidadDisponible((Integer) rs.getObject("cantidad_disponible"));
				tarjeta.getArbolito().setId((Integer) rs.getObject("id_arbolito"));
				tarjeta.getConvenio().setId((Integer) rs.getObject("id_convenio"));
				tarjeta.getConvenio().setNombre((String) rs.getObject("nombre_convenio"));

				tarjetas.add(tarjeta);
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {

			if (rs != null) {
				rs.close();
			}

		}
		return tarjetas;

	}

}
