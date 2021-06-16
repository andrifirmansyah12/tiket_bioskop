/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.formBioskop;
import java.sql.SQLException;

public interface controllerBioskop {
    public void Simpan(formBioskop tb) throws SQLException;
    public void Update(formBioskop tb) throws SQLException;
    public void Delete(formBioskop tb) throws SQLException;
    public void Tampil(formBioskop tb) throws SQLException;
    public void KlikTable(formBioskop tb) throws SQLException;
    public void Bersih(formBioskop tb) throws SQLException;
    
}
