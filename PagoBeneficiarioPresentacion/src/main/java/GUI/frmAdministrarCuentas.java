/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.CuentaBancariaDTO;
import excepciones.NegocioException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.CuentaBancariaNegocio;
import negocio.ICuentaBancariaNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Arturo ITSON
 */
public class frmAdministrarCuentas extends javax.swing.JFrame {

    
    private ICuentaBancariaNegocio negocio = new CuentaBancariaNegocio();

    /**
     * Creates new form frmAdministrarCuentas
     */
    public frmAdministrarCuentas() {
        initComponents();
        cargarMetodosIniciales();
    }

    private void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaCuentas();
        this.cargarCuentaEnTabla();
    }

    private void editarCuentaTabla(CuentaBancariaDTO cuenta) {
        try {
            this.negocio.actualizar(cuenta);
            JOptionPane.showMessageDialog(this, "Cuenta editada");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCuentaTabla(long val1) {
        try {
            this.negocio.eliminar((long) val1);
            JOptionPane.showMessageDialog(this, "Cuenta Eliminada");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarConfiguracionInicialTablaCuentas() {
        ActionListener onEditarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        };

        int indiceColumnaEditar = 6;
        TableColumnModel modeloColumnas = this.tblCuentas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar un alumno
                eliminar();
            }
        };
        int indiceColumnaEliminar = 7;
        modeloColumnas = this.tblCuentas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));

    }

    private long getIdSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 0;
            long idCuentaSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idCuentaSeleccionado;
        } else {
            return 0;
        }
    }

    private String getNumCuentaSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 1;
            String numCuentaSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return numCuentaSeleccionado;
        } else {
            return null;
        }
    }

    private String getClaveSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 2;
            String claveCuentaSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return claveCuentaSeleccionado;
        } else {
            return null;
        }
    }

    private String getBancoSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 3;
            String bancoCuentaSeleccionado = (String) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return bancoCuentaSeleccionado;
        } else {
            return null;
        }
    }

    private long getIdBeneficiarioSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 4;
            long idBeneficiarioSeleccionado = (long) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idBeneficiarioSeleccionado;
        } else {
            return 0;
        }
    }

    private boolean getEliminadaSeleccionadoTablaCuentas() {
        int indiceFilaSeleccionada = this.tblCuentas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCuentas.getModel();
            int indiceColumnaId = 5;
            boolean eliminadoSeleccionado = (boolean) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return eliminadoSeleccionado;
        } else {
            return false;
        }
    }

    private void editar() {
        //Metodo para regresar el alumno seleccionado

        long id = this.getIdSeleccionadoTablaCuentas();
        String numeroCuenta = this.getNumCuentaSeleccionadoTablaCuentas();
        String clave = this.getClaveSeleccionadoTablaCuentas();
        String banco = this.getBancoSeleccionadoTablaCuentas();
        long idBeneficiario = this.getIdBeneficiarioSeleccionadoTablaCuentas();
        boolean eliminado = this.getEliminadaSeleccionadoTablaCuentas();

        CuentaBancariaDTO cuenta = new CuentaBancariaDTO();
        cuenta.setBanco(banco);
        cuenta.setBeneficiarioId(idBeneficiario);
        cuenta.setClabe(clave);
        cuenta.setEliminada(eliminado);
        cuenta.setId(id);
        cuenta.setNumeroDeCuenta(numeroCuenta);

        editarCuentaTabla(cuenta);

    }

    private void eliminar() {
        //Metodo para regresar el alumno seleccionado
        long id = this.getIdSeleccionadoTablaCuentas();
        eliminarCuentaTabla(id);
        cargarMetodosIniciales();

    }

    private void llenarTablaBeneficiarios(List<CuentaBancariaDTO> cuentasLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCuentas.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (cuentasLista != null) {
            cuentasLista.forEach(row -> {
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getNumeroDeCuenta();
                fila[2] = row.getClabe();
                fila[3] = row.getBanco();
                fila[4] = row.getBeneficiarioId();
                fila[5] = row.getEliminada();
                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarCuentaEnTabla() {
        try {
            List<CuentaBancariaDTO> beneficiarios = this.negocio.buscarCuentaTabla();
            this.llenarTablaBeneficiarios(beneficiarios);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convertirABeneficiarioDTO() {

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
        tblCuentas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnNuevoRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar Cuentas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblCuentas.setBackground(new java.awt.Color(225, 225, 225));
        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Numero de Cuenta", "Clave", "Banco", "Id Beneficiario", "Eliminada", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCuentas);

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
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmInicioAdmin adminFrame = new  frmInicioAdmin ();
        adminFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoRegistroActionPerformed
        dlgRegistrarCuenta rc = new dlgRegistrarCuenta();
        rc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoRegistro;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
