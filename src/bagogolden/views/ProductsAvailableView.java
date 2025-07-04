/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bagogolden.views;

import bagogolden.controllers.ProductController;
import bagogolden.controllers.StatisticsController;
import bagogolden.controllers.TransactionController;
import bagogolden.controllers.UserController;
import bagogolden.models.Product;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gilso
 */
public final class ProductsAvailableView extends javax.swing.JFrame {
    UserController userController = new UserController();
    ProductController productController = new ProductController();
    TransactionController transactionController = new TransactionController(productController);
    StatisticsController statisticsController = new StatisticsController(userController, transactionController, productController);
    /**
     * Creates new form ProductsAvailableView
     */
    public ProductsAvailableView() {
        initComponents();
        loadProductsInTable(productController.getProducts());
    }
    
    public void loadProductsInTable(List<Product> produtos) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        produtos.forEach(p -> {
            Object[] linha = {
                p.getId(),
                p.getSellerId(),
                p.getCategory().name(),
                p.getMaterial().name(),
                p.getPrice(),
                p.getDescription()
            };
            model.addRow(linha);
        });
    }
    
    public String generateStatisticsTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append("ESTATÍSTICAS\n\n");
        sb.append("Média de Idade: ").append(statisticsController.getAverageAge()).append("\n");
        sb.append("Média de Preço: ").append(statisticsController.getAveragePrice()).append("\n");
        sb.append("Produto mais solicitado: ").append(statisticsController.getMostPopularProduct()).append("\n");
        sb.append("Produto menos solicitado: ").append(statisticsController.getLeastPopularProduct()).append("\n");
        sb.append("Percentagem por Gênero: ").append(statisticsController.getGenderPercentage()).append("\n");

        LocalDate data = LocalDate.of(2025, 6, 30); 
        sb.append("\nAniversariantes em ").append(data).append(":\n");
        statisticsController.getBirthdaysOnDate(data).forEach(u ->
            sb.append("- ").append(u.getName()).append(" (").append(u.getRole()).append(")\n")
        );

        return sb.toString();
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProductsAvailable = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuy = new javax.swing.JButton();
        btnViewStatistics = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtStatistics = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProductsAvailable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProductsAvailable.setText("Produtos Disponíveis");

        separator.setBackground(new java.awt.Color(255, 204, 0));
        separator.setForeground(new java.awt.Color(255, 204, 0));

        lblTitle.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 204, 0));
        lblTitle.setText("BAGO GOLDEN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID do Produto", "ID do Vendedor", "Categoria", "Material", "Preço", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnBuy.setBackground(new java.awt.Color(51, 153, 255));
        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("COMPRAR");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnViewStatistics.setBackground(new java.awt.Color(51, 255, 0));
        btnViewStatistics.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnViewStatistics.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStatistics.setText("VER ESTATÍSTICAS");
        btnViewStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStatisticsActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("SAIR");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        txtStatistics.setColumns(20);
        txtStatistics.setRows(5);
        jScrollPane2.setViewportView(txtStatistics);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProductsAvailable)
                .addGap(202, 202, 202))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewStatistics)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuy))
                    .addComponent(separator)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductsAvailable)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuy)
                    .addComponent(btnViewStatistics)
                    .addComponent(btnExit))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnViewStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStatisticsActionPerformed
        // TODO add your handling code here:
        String estatisticas = generateStatisticsTxt();
        txtStatistics.setText(estatisticas);
    }//GEN-LAST:event_btnViewStatisticsActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        SaleView slv = new SaleView();
        slv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductsAvailableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsAvailableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsAvailableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsAvailableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsAvailableView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnViewStatistics;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblProductsAvailable;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextArea txtStatistics;
    // End of variables declaration//GEN-END:variables
}
