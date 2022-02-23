package cn.edu.jit.wdnv.java.sims.view;

import cn.edu.jit.wdnv.java.sims.model.Teacher;
import cn.edu.jit.wdnv.java.sims.dao.TeacherDao;
import cn.edu.jit.wdnv.java.sims.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacherFrm extends JInternalFrame {
    private final JTextField teacherNameTextField;
    private final JTextField teacherTitleTextField;
    private final JTextField teacherAgeTextField;
    private final JRadioButton teacherSexManRadioButton;
    private final JRadioButton teacherSexFemalRadioButton;
    private final JPasswordField teacherPasswordField;

    /**
     * Create the frame.
     */
    public AddTeacherFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u6DFB\u52A0\u6559\u5E08");
        setBounds(100, 100, 450, 371);

        JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        label.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/老师.png")));

        teacherNameTextField = new JTextField();
        teacherNameTextField.setColumns(10);

        JLabel label_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
        label_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/性别.png")));
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        ButtonGroup buttonGroup = new ButtonGroup();
        teacherSexManRadioButton = new JRadioButton("\u7537");
        teacherSexManRadioButton.setSelected(true);
        teacherSexManRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        teacherSexFemalRadioButton = new JRadioButton("\u5973");
        teacherSexFemalRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        buttonGroup.add(teacherSexManRadioButton);
        buttonGroup.add(teacherSexFemalRadioButton);

        JLabel label_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
        label_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/职称评定.png")));
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        teacherTitleTextField = new JTextField();
        teacherTitleTextField.setColumns(10);

        JLabel label_3 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
        label_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/年龄.png")));
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        teacherAgeTextField = new JTextField();
        teacherAgeTextField.setColumns(10);

        JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                addTeacherAct(ae);
            }
        });
        submitButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/确认.png")));
        submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JButton resetButton = new JButton("\u91CD\u7F6E\u8868\u5355");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                resetValue(ae);
            }
        });
        resetButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/重置.png")));
        resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JLabel label_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
        label_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/密码.png")));
        label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        teacherPasswordField = new JPasswordField();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(104)
                                .addComponent(submitButton)
                                .addGap(40)
                                .addComponent(resetButton)
                                .addContainerGap(68, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(87)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(label_1)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(teacherSexManRadioButton)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(teacherSexFemalRadioButton))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(label)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(label_2)
                                                        .addComponent(label_3)
                                                        .addComponent(label_4))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(teacherPasswordField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                        .addComponent(teacherAgeTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                        .addComponent(teacherTitleTextField, 152, 152, Short.MAX_VALUE))))
                                .addGap(95))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(26)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_1)
                                        .addComponent(teacherSexManRadioButton)
                                        .addComponent(teacherSexFemalRadioButton))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_2)
                                        .addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_3)
                                        .addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(teacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(submitButton)
                                        .addComponent(resetButton))
                                .addGap(32))
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
                    AddTeacherFrm frame = new AddTeacherFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void resetValue(ActionEvent ae) {
        // TODO Auto-generated method stub
        teacherNameTextField.setText("");
        teacherTitleTextField.setText("");
        teacherAgeTextField.setText("");
        teacherSexManRadioButton.setSelected(true);
        teacherPasswordField.setText("");
    }

    protected void addTeacherAct(ActionEvent ae) {
        // TODO Auto-generated method stub
        String teacherName = teacherNameTextField.getText();
        String teacherSex = teacherSexManRadioButton.isSelected() ? teacherSexManRadioButton.getText() : teacherSexFemalRadioButton.getText();
        String teacherTitle = teacherTitleTextField.getText();
        String teacherPassword = teacherPasswordField.getText();
        int teacherAge = 0;
        try {
            teacherAge = Integer.parseInt(teacherAgeTextField.getText());
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
            return;
        }
        if (StringUtil.isEmpty(teacherName)) {
            JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
            return;
        }
        if (StringUtil.isEmpty(teacherTitle)) {
            JOptionPane.showMessageDialog(this, "教师职称必须填写！");
            return;
        }
        if (teacherAge == 0 || teacherAge < 0) {
            JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
            return;
        }
        if (StringUtil.isEmpty(teacherPassword)) {
            JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
            return;
        }
        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        teacher.setSex(teacherSex);
        teacher.setTitle(teacherTitle);
        teacher.setAge(teacherAge);
        teacher.setPassword(teacherPassword);
        TeacherDao teacherDao = new TeacherDao();
        if (teacherDao.addTeacher(teacher)) {
            JOptionPane.showMessageDialog(this, "教师添加成功！");
        } else {
            JOptionPane.showMessageDialog(this, "教师添加失败！");
        }
        resetValue(ae);
    }
}
