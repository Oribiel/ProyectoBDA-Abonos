/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.BeneficiarioDTO;
import excepciones.NegocioException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.BeneficiarioNegocio;
import negocio.IBeneficiarioNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Arturo ITSON
 */
public class frmAdministrarBeneficiarios extends javax.swing.JFrame {

    private IBeneficiarioNegocio negocio = new BeneficiarioNegocio();

    public frmAdministrarBeneficiarios() {
        initComponents();
        this.negocio=negocio;
        cargarMetodosIniciales();

    }

    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaBeneficiarios();
        this.cargarBeneficiariosEnTabla();

    }

    private void insertarBeneficiarioTabla(BeneficiarioDTO beneficiario) {
        try {
            this.negocio.crear(beneficiario);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarBeneficiarioTabla(BeneficiarioDTO beneficiario) {
        try {
            this.negocio.actualizar(beneficiario);
            JOptionPane.showMessageDialog(this, "Beneficiario editado");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void eliminarBeneficiarioTabla(long val1) {
        try {
            this.negocio.eliminar((long) val1);
            JOptionPane.showMessageDialog(this, "Beneficiario Eliminado");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargarConfiguracionInicialTablaBeneficiarios() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                editar();

            }
        };

        int indiceColumnaEditar = 8;
        TableColumnModel modeloColumnas = this.tblBeneficiarios.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar",
                        onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar un alumno
                eliminar();
            }
        };
        int indiceColumnaEliminar = 9;
        modeloColumnas = this.tblBeneficiarios.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar",
                        onEliminarClickListener));

    }

    private long getIdSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 0;
            long idBeneficiarioSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idBeneficiarioSeleccionado;
        } else {
            return 0;
        }
    }

    private String getClaveSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 1;
            String claveBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return claveBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private String getNombreSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 2;
            String nombreBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return nombreBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private String getAPSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 3;
            String aPBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return aPBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private String getAMSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 4;
            String aMBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return aMBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private String getUsuarioSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 5;
            String usuarioBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return usuarioBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private String getContrasenaSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 6;
            String contrasenaBeneficiarioSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return contrasenaBeneficiarioSeleccionado;
        } else {
            return null;
        }
    }

    private double getSaldoSeleccionadoTablaBeneficiarios() {
        int indiceFilaSeleccionada = this.tblBeneficiarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblBeneficiarios.getModel();
            int indiceColumnaId = 7;
            double saldoBeneficiarioSeleccionado = (double) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return saldoBeneficiarioSeleccionado;
        } else {
            return 0.0;
        }
    }

    private void editar() {
        //Metodo para regresar el alumno seleccionado

        String clave = this.getClaveSeleccionadoTablaBeneficiarios();
        String nombre = this.getNombreSeleccionadoTablaBeneficiarios();
        String aPaterno = this.getAPSeleccionadoTablaBeneficiarios();
        String aMaterno = this.getAMSeleccionadoTablaBeneficiarios();
        String usuario = this.getUsuarioSeleccionadoTablaBeneficiarios();
        long id = this.getIdSeleccionadoTablaBeneficiarios();
        double saldo = this.getSaldoSeleccionadoTablaBeneficiarios();
        String contra = this.getContrasenaSeleccionadoTablaBeneficiarios();

        BeneficiarioDTO beneficiario = new BeneficiarioDTO();
        beneficiario.setClaveContrato(clave);
        beneficiario.setMaterno(aMaterno);
        beneficiario.setNombres(nombre);
        beneficiario.setPaterno(aPaterno);
        beneficiario.setSaldo(saldo);
        beneficiario.setUsuario(usuario);
        beneficiario.setId(id);
        beneficiario.setContrasena(contra);

        editarBeneficiarioTabla(beneficiario);

    }

    private void eliminar() {
        //Metodo para regresar el beneficiario seleccionado
        long id = this.getIdSeleccionadoTablaBeneficiarios();
        eliminarBeneficiarioTabla(id);
        cargarMetodosIniciales();

    }

    private void llenarTablaBeneficiarios(List<BeneficiarioDTO> beneficiariosLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBeneficiarios.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (beneficiariosLista != null) {
            beneficiariosLista.forEach(row -> {
                Object[] fila = new Object[8];
                fila[0] = row.getId();
                fila[1] = row.getClaveContrato();
                fila[2] = row.getMaterno();
                fila[3] = row.getPaterno();
                fila[4] = row.getMaterno();
                fila[5] = row.getUsuario();
                fila[6] = row.getContrasena();
                fila[7] = row.getSaldo();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarBeneficiariosEnTabla() {
        try {
            List<BeneficiarioDTO> beneficiarios = this.negocio.buscarBeneficiarioTabla();
            this.llenarTablaBeneficiarios(beneficiarios);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeneficiarios = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnNuevoRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar Beneficiarios");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblBeneficiarios.setBackground(new java.awt.Color(225, 225, 225));
        tblBeneficiarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Clave", "Nombres", "Apellido Paterno", "Apelldio Materno", "Usuario", "contrasena", "Saldo", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblBeneficiarios);

        btnRegresar.setBackground(new java.awt.Color(23, 154, 249));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnNuevoRegistro.setBackground(new java.awt.Color(23, 154, 249));
        btnNuevoRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoRegistro.setText("Nuevo Registro");
        btnNuevoRegistro.setBorder(null);
        btnNuevoRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(520, 520, 520)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmInicioAdmin adminFrame = new frmInicioAdmin();
        adminFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoRegistroActionPerformed
        dlgRegistrarBeneficiario adminFrame = new dlgRegistrarBeneficiario(this, true, negocio);
        adminFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoRegistroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoRegistro;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBeneficiarios;
    // End of variables declaration//GEN-END:variables
}
