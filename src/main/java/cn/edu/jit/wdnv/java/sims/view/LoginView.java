package cn.edu.jit.wdnv.java.sims.view;

import cn.edu.jit.wdnv.java.sims.model.Admin;
import cn.edu.jit.wdnv.java.sims.model.Student;
import cn.edu.jit.wdnv.java.sims.model.Teacher;
import cn.edu.jit.wdnv.java.sims.model.UserType;
import cn.edu.jit.wdnv.java.sims.dao.AdminDao;
import cn.edu.jit.wdnv.java.sims.dao.StudentDao;
import cn.edu.jit.wdnv.java.sims.dao.TeacherDao;
import cn.edu.jit.wdnv.java.sims.util.StringUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame { //Swing Desingner Auto-Generated
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JComboBox usertypeComboBox;
    private JLabel userTypeLabel;
    private JLabel title;

    public LoginView() {
        super("学生信息管理系统");
        setVisible(true); //设置窗口状态：显示(必须设置)
        setBounds(100, 100, 720, 460);  //设置窗口显示位置和窗口大小
        add(loginPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        usertypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));

        loginButton.addActionListener(new ActionListener() { //登录按钮监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAct();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAct();
            }
        }); //重置按钮监听器
    }

    protected void loginAct() { //登录操作
        // TODO Auto-generated method stub
        String userName = usernameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());
        UserType selectedItem = (UserType) usertypeComboBox.getSelectedItem();
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(this, "用户名不能为空！");
            return;
        } //判断用户名密码是否为空
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(this, "密码不能为空！");
            return;
        }
        Admin admin = null;
        if ("系统管理员".equals(selectedItem.getName())) {
            AdminDao adminDao = new AdminDao();
            Admin adminTmp = new Admin();
            adminTmp.setName(userName);
            adminTmp.setPassword(password);
            admin = adminDao.login(adminTmp);
            adminDao.closeDao();
            if (admin == null) {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + admin.getName() + "登录本系统！");
            this.dispose();
            new MainFrm(selectedItem, admin).setVisible(true);
        } else if ("教师".equals(selectedItem.getName())) {
            //教师登录
            Teacher teacher = null;
            TeacherDao teacherDao = new TeacherDao();
            Teacher teacherTmp = new Teacher();
            teacherTmp.setName(userName);
            teacherTmp.setPassword(password);
            teacher = teacherDao.login(teacherTmp);
            teacherDao.closeDao();
            if (teacher == null) {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + teacher.getName() + "登录本系统！");
            this.dispose();
            new MainFrm(selectedItem, teacher).setVisible(true);
        } else {
            //学生登录
            Student student = null;
            StudentDao studentDao = new StudentDao();
            Student studentTmp = new Student();
            studentTmp.setName(userName);
            studentTmp.setPassword(password);
            student = studentDao.login(studentTmp);
            studentDao.closeDao();
            if (student == null) {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this, "欢迎【" + selectedItem.getName() + "】：" + student.getName() + "登录本系统！");
             this.dispose();
            new MainFrm(selectedItem, student).setVisible(true);
        }
    }

    protected void resetAct() {
        // TODO Auto-generated method stub
        usernameTextField.setText("");
        passwordField.setText("");
        usertypeComboBox.setSelectedIndex(0);
    }

}