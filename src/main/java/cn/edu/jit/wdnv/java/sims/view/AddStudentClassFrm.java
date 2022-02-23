package cn.edu.jit.wdnv.java.sims.view;

import cn.edu.jit.wdnv.java.sims.dao.ClassDao;
import cn.edu.jit.wdnv.java.sims.model.StudentClass;
import cn.edu.jit.wdnv.java.sims.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentClassFrm extends JInternalFrame {
    private final JTextField classNameTextField;
    private final JTextArea classInfotextArea;

    /**
     * Create the frame.
     */
    public AddStudentClassFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
        setBounds(100, 100, 450, 300);

        JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
        label.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/班级名称.png")));
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        classNameTextField = new JTextField();
        classNameTextField.setColumns(10);

        JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
        label_1.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/班级介绍.png")));
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        classInfotextArea = new JTextArea();

        JButton submitButton = new JButton("\u63D0\u4EA4");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                submitClass(ae);
            }
        });
        submitButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/确认.png")));
        submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JButton restButton = new JButton("\u91CD\u7F6E");
        restButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValue(e);
            }
        });
        restButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/重置.png")));
        restButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(submitButton)
                                                .addGap(72)
                                                .addComponent(restButton))
                                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                                .addGap(73)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label_1)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(classInfotextArea))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(label)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(88, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(32)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(39)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_1)
                                        .addComponent(classInfotextArea, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(restButton)
                                        .addComponent(submitButton))
                                .addGap(18))
        );
        getContentPane().setLayout(groupLayout);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudentClassFrm frame = new AddStudentClassFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void submitClass(ActionEvent ae) {
        // TODO Auto-generated method stub
        String className = classNameTextField.getText();
        String classInfo = classInfotextArea.getText();
        if (StringUtil.isEmpty(className)) {
            JOptionPane.showMessageDialog(this, "班级名称不能为空！");
            return;
        }
        StudentClass scl = new StudentClass();
        scl.setName(className);
        scl.setInfo(classInfo);
        ClassDao classDao = new ClassDao();
        if (classDao.addClass(scl)) {
            JOptionPane.showMessageDialog(this, "班级添加成功！");
        } else {
            JOptionPane.showMessageDialog(this, "班级添加失败！");
        }
        classDao.closeDao();
        resetValue(ae);
    }

    protected void resetValue(ActionEvent e) {
        // TODO Auto-generated method stub
        classNameTextField.setText("");
        classInfotextArea.setText("");
    }
}