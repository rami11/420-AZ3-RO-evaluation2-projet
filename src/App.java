import view.ItemController;
import view.ItemModel;
import view.ItemView;

import java.awt.*;
import java.util.logging.Logger;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getSimpleName());

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            ItemView view = new ItemView();
            ItemModel model = new ItemModel();

            // Controller
            new ItemController(view, model);

            view.setVisible(true);
        });
    }

}
