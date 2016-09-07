package common.classUtil.tools;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyEclipseKeyGen
{
  private Display display = null;

  private Shell shell = null;

  private Group chooseVer_G = null;

  private Group proOrStd_G = null;

  private Button ver5_5_R = null;

  private Button ver5_5_P_R = null;

  private Button pro_B = null;

  private Button std_B = null;

  private Button generate_B = null;

  private Label sser_L = null;

  private Label NumOfLic_L = null;

  private Label ver_L = null;

  private Label ssc_L = null;

  private Text sser_T = null;

  private Text NumOfLic_T = null;

  private Text ver_T = null;

  private Text ssc_T = null;

  private MyEclipseKeyGen() {
    this.display = Display.getDefault();
    this.shell = new Shell(this.display, 192);
    this.shell.setImage(new Image(Display.getCurrent(), "Images/myeclipse.gif"));
    this.shell.setText("MyEclipseCrack");
    this.shell.setSize(256, 356);
    this.shell
      .setLocation(
      (Toolkit.getDefaultToolkit().getScreenSize().width - 
      this.shell.getBounds().width) / 2, 
      (Toolkit.getDefaultToolkit().getScreenSize().height - 
      this.shell.getBounds().height) / 2);
    this.shell.open();

    this.chooseVer_G = new Group(this.shell, 0);
    this.chooseVer_G.setText("Choose Version");
    this.chooseVer_G.setBounds(10, 4, 230, 50);

    this.ver5_5_R = new Button(this.chooseVer_G, 16);
    this.ver5_5_R.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent arg0) {
        MyEclipseKeyGen.this.ver_T.setText("");
        MyEclipseKeyGen.this.ver_T.setEditable(false);
      }
    });
    this.ver5_5_R.setSelection(true);
    this.ver5_5_R.setBounds(10, 20, 95, 20);
    this.ver5_5_R.setText("5.5GA && Last");

    this.ver5_5_P_R = new Button(this.chooseVer_G, 16);
    this.ver5_5_P_R.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent arg0) {
        MyEclipseKeyGen.this.ver_T.setEditable(true);
        MyEclipseKeyGen.this.ver_T.setText("511");
      }
    });
    this.ver5_5_P_R.setBounds(110, 20, 115, 20);
    this.ver5_5_P_R.setText("5.5GA && Previous");

    this.proOrStd_G = new Group(this.shell, 0);
    this.proOrStd_G.setText("Professional OR Standard");
    this.proOrStd_G.setBounds(10, 60, 230, 50);

    this.pro_B = new Button(this.proOrStd_G, 16);
    this.pro_B.setSelection(true);
    this.pro_B.setBounds(10, 20, 95, 20);
    this.pro_B.setText("Professional");

    this.std_B = new Button(this.proOrStd_G, 16);
    this.std_B.setBounds(110, 20, 70, 20);
    this.std_B.setText("Standard");

    this.sser_L = new Label(this.shell, 0);
    this.sser_L.setText("Subscriber");
    this.sser_L.setBounds(10, 120, 60, 15);

    this.sser_T = new Text(this.shell, 2048);
    this.sser_T.setText(System.getProperty("user.name"));
    this.sser_T.setBounds(10, 135, 230, 20);

    this.NumOfLic_L = new Label(this.shell, 0);
    this.NumOfLic_L.setText("Number Of Licenses(Default 5, Max 999)");
    this.NumOfLic_L.setBounds(10, 165, 230, 15);

    this.NumOfLic_T = new Text(this.shell, 2048);
    this.NumOfLic_T.setText("5");
    this.NumOfLic_T.setBounds(10, 180, 230, 20);

    this.ver_L = new Label(this.shell, 0);
    this.ver_L.setText("Version");
    this.ver_L.setBounds(10, 210, 45, 15);

    this.ver_T = new Text(this.shell, 2048);
    this.ver_T.setEditable(false);
    this.ver_T.setBounds(10, 225, 230, 20);

    this.ssc_L = new Label(this.shell, 0);
    this.ssc_L.setText("Subscription Code");
    this.ssc_L.setBounds(10, 255, 105, 15);

    this.ssc_T = new Text(this.shell, 2048);
    this.ssc_T.setEditable(false);
    this.ssc_T.setBounds(10, 270, 230, 20);

    this.generate_B = new Button(this.shell, 0);
    this.generate_B.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent arg0) {
        String userId = MyEclipseKeyGen.this.sser_T.getText().trim();
        if (userId.equals("")) {
          userId = System.getProperty("user.name");
          MyEclipseKeyGen.this.sser_T.setText(userId);
        }
        String licenseNum = MyEclipseKeyGen.this.NumOfLic_T.getText().trim();
        if (licenseNum.equals("")) {
          licenseNum = "5";
          MyEclipseKeyGen.this.NumOfLic_T.setText("5");
        }
        String version = MyEclipseKeyGen.this.ver_T.getText().trim();
        if (version.equals("")) {
          if (MyEclipseKeyGen.this.ver5_5_R.getSelection()) {
            version = "300";
            MyEclipseKeyGen.this.ver_T.setEditable(false);
          } else {
            version = "511";
            MyEclipseKeyGen.this.ver_T.setText(version);
          }
        }
        MyEclipseKeyGen.this.ssc_T.setText(MyEclipseKeyGen.this
          .getSerial(userId, version, licenseNum, 
          MyEclipseKeyGen.this.ver5_5_R.getSelection(), MyEclipseKeyGen.this.pro_B.getSelection()));
      }
    });
    this.generate_B.setText("Generate");
    this.generate_B.setBounds(150, 296, 90, 23);

    this.shell.layout();
    while (!this.shell.isDisposed()) {
      if (!this.display.readAndDispatch())
        this.display.sleep();
    }
    this.display.dispose();
  }

  private String getSerial(String userId, String version, String licenseNum, boolean selected, boolean proORstd)
  {
    Calendar cal = Calendar.getInstance();
    cal.add(1, 3);
    cal.add(6, -1);
    NumberFormat nf = new DecimalFormat("000");
    licenseNum = nf.format(Integer.valueOf(licenseNum));
    String verTime = selected ? 
      "-" + new SimpleDateFormat("yyMMdd").format(cal.getTime()) + 
      "0" : "-9912310";
    String type = proORstd ? "YE3MP-" : "YE2MY-";
    String need = userId.substring(0, 1) + 
      type + version + licenseNum + 
      verTime;
    String dx = need + 
      "Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself." + 
      userId;
    int suf = decode(dx);
    String code = need + 
      String.valueOf(suf);
    return change(code);
  }

  private int decode(String s) {
    int i = 0;
    char[] ac = s.toCharArray();
    int j = 0;
    for (int k = ac.length; j < k; j++) {
      i = 31 * i + ac[j];
    }
    return Math.abs(i);
  }

  private String change(String s) {
    byte[] abyte0 = s.getBytes();
    char[] ac = new char[s.length()];
    int i = 0;
    for (int k = abyte0.length; i < k; i++) {
      int j = abyte0[i];
      if ((j >= 48) && (j <= 57))
        j = (j - 48 + 5) % 10 + 48;
      else if ((j >= 65) && (j <= 90))
        j = (j - 65 + 13) % 26 + 65;
      else if ((j >= 97) && (j <= 122)) {
        j = (j - 97 + 13) % 26 + 97;
      }
      ac[i] = (char)j;
    }
    return String.valueOf(ac);
  }

  public static void main(String[] args)
  {
    new MyEclipseKeyGen();
  }
}