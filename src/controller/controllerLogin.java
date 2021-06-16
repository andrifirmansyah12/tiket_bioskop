
package controller;

import java.sql.SQLException;
import view.formLogin;


public interface controllerLogin {
    public void Login (formLogin lgn) throws SQLException;
    public void Bersih (formLogin lgn) throws SQLException;
}
