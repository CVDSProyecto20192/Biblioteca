package edu.eci.cvds.view;

import javax.swing.JOptionPane;

public final class Messages {

	public static void lanzarMensajeAplicacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void lanzarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
	}

}
