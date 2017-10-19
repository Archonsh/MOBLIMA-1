package org.gp3.moblima.view.admin;

import org.gp3.moblima.controller.Manager;
import org.gp3.moblima.model.Admin;
import org.gp3.moblima.view.BaseMenu;

import static org.gp3.moblima.model.Constant.TableName.ADMIN;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class StaffLogin extends BaseMenu {
    public StaffLogin(BaseMenu previousMenu) {
        super(previousMenu);
    }

    @Override
    public BaseMenu execute() {
        printTitle("Please Login Using Username and Password");

        final String username = read("Username: ");
        final String password = read("Password: ");

        Manager man = Manager.getInstance();

        Admin admin = man.getEntry(ADMIN,
                (Admin i) -> (
                        i.getUsername().equals(username) &&
                                i.getPassword().equals(password))
        );

        if (admin == null) {
            return this.getPreviousMenu();
        } else {
            // In StaffMainMenu back option will redirect to MainMenu
            return new StaffMainMenu(this.getPreviousMenu(), admin);
        }

    }
}
