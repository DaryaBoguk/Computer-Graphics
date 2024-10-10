import javax.swing.*;
import java.awt.*;

public class Convert extends JFrame {
    private JPanel colorDisplay;
    private JTextField rField, gField, bField, cField, mField, yField, kField, hField, sField, lField;
    private JSlider rSlider, gSlider, bSlider,cSlider, mSlider, ySlider, kSlider, hSlider, sSlider, lSlider;
    private int R=0, C=0, H=0;

    public Convert() {
        setTitle("Converter");
        setSize(650, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        JPanel rgbPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        rgbPanel.setBorder(BorderFactory.createTitledBorder("RGB"));
        mainPanel.add(rgbPanel);

        JLabel rLabel = new JLabel("R");
        rgbPanel.add(rLabel);
        rField = new JTextField("0");
        rgbPanel.add(rField);
        rSlider = new JSlider(0, 255);
        rgbPanel.add(rSlider);

        JLabel gLabel = new JLabel("G");
        rgbPanel.add(gLabel);
        gField = new JTextField("0");
        rgbPanel.add(gField);
        gSlider = new JSlider(0, 255);
        rgbPanel.add(gSlider);

        JLabel bLabel = new JLabel("B");
        rgbPanel.add(bLabel);
        bField = new JTextField("0");
        rgbPanel.add(bField);
        bSlider = new JSlider(0, 255);
        rgbPanel.add(bSlider);

        JButton rgbButton = new JButton("Set RGB");
        rgbPanel.add(rgbButton);

        JPanel cmykPanel = new JPanel(new GridLayout(5, 3, 5, 5));
        cmykPanel.setBorder(BorderFactory.createTitledBorder("CMYK"));
        mainPanel.add(cmykPanel);

        JLabel cLabel = new JLabel("C");
        cmykPanel.add(cLabel);
        cField = new JTextField("0");
        cmykPanel.add(cField);
        cSlider = new JSlider(0, 100);
        cmykPanel.add(cSlider);

        JLabel mLabel = new JLabel("M");
        cmykPanel.add(mLabel);
        mField = new JTextField("0");
        cmykPanel.add(mField);
        mSlider = new JSlider(0, 100);
        cmykPanel.add(mSlider);

        JLabel yLabel = new JLabel("Y");
        cmykPanel.add(yLabel);
        yField = new JTextField("0");
        cmykPanel.add(yField);
        ySlider = new JSlider(0, 100);
        cmykPanel.add(ySlider);

        JLabel kLabel = new JLabel("K");
        cmykPanel.add(kLabel);
        kField = new JTextField("100");
        cmykPanel.add(kField);
        kSlider = new JSlider(0, 100);
        cmykPanel.add(kSlider);

        JButton cmykButton = new JButton("Set CMYK");
        cmykPanel.add(cmykButton);

        JPanel hlsPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        hlsPanel.setBorder(BorderFactory.createTitledBorder("HLS"));
        mainPanel.add(hlsPanel);

        JLabel hLabel = new JLabel("H");
        hlsPanel.add(hLabel);
        hField = new JTextField("0");
        hlsPanel.add(hField);
        hSlider = new JSlider(0, 360);
        hlsPanel.add(hSlider);

        JLabel sLabel = new JLabel("S");
        hlsPanel.add(sLabel);
        sField = new JTextField("0");
        hlsPanel.add(sField);
        sSlider = new JSlider(0, 100);
        hlsPanel.add(sSlider);

        JLabel lLabel = new JLabel("L");
        hlsPanel.add(lLabel);
        lField = new JTextField("0");
        hlsPanel.add(lField);
        lSlider = new JSlider(0, 100);
        hlsPanel.add(lSlider);

        JButton hlsButton = new JButton("Set HLS");
        hlsPanel.add(hlsButton);

        // Панель для отображения цвета
        colorDisplay = new JPanel();
        colorDisplay.setBackground(Color.BLACK);
        colorDisplay.setPreferredSize(new Dimension(440, 100));
        add(colorDisplay, BorderLayout.SOUTH);

        // Панель для кнопки "Choose Color"
        JPanel chooseColorPanel = new JPanel();
        JButton chooseColorButton = new JButton("Choose Color");
        chooseColorPanel.add(chooseColorButton);
        add(chooseColorPanel, BorderLayout.NORTH);

        // Слушатели событий
        chooseColorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", colorDisplay.getBackground());
            if (selectedColor != null) {
                rSlider.setValue(selectedColor.getRed());
                gSlider.setValue(selectedColor.getGreen());
                bSlider.setValue(selectedColor.getBlue());
                updateFromRGB(++R);
                --R;
            }
        });

        rSlider.addChangeListener(e -> {
            rField.setText(String.valueOf(rSlider.getValue()));
            updateFromRGB(++R);
            --R;
        });

        gSlider.addChangeListener(e -> {
            gField.setText(String.valueOf(gSlider.getValue()));
            updateFromRGB(++R);
            --R;
        });

        bSlider.addChangeListener(e -> {
            bField.setText(String.valueOf(bSlider.getValue()));
            updateFromRGB(++R);
            --R;
        });

        rgbButton.addActionListener(e -> {
            rSlider.setValue(Integer.parseInt(rField.getText()));
            gSlider.setValue(Integer.parseInt(gField.getText()));
            bSlider.setValue(Integer.parseInt(bField.getText()));
        });

        cSlider.addChangeListener(e -> {
            cField.setText(String.valueOf(cSlider.getValue()));
            updateFromCMYK(++C);
            --C;
        });

        mSlider.addChangeListener(e -> {
            mField.setText(String.valueOf(mSlider.getValue()));
            updateFromCMYK(++C);
            --C;
        });

        ySlider.addChangeListener(e -> {
            yField.setText(String.valueOf(ySlider.getValue()));
            updateFromCMYK(++C);
            --C;
        });

        kSlider.addChangeListener(e -> {
            kField.setText(String.valueOf(kSlider.getValue()));
            updateFromCMYK(++C);
            --C;
        });

        cmykButton.addActionListener(e -> {
            cSlider.setValue(Integer.parseInt(cField.getText()));
            mSlider.setValue(Integer.parseInt(mField.getText()));
            ySlider.setValue(Integer.parseInt(yField.getText()));
            kSlider.setValue(Integer.parseInt(kField.getText()));
        });

        hSlider.addChangeListener(e -> {
            hField.setText(String.valueOf(hSlider.getValue()));
            updateFromHLS(++H);
            --H;
        });

        sSlider.addChangeListener(e -> {
            sField.setText(String.valueOf(sSlider.getValue()));
            updateFromHLS(++H);
            --H;
        });

        lSlider.addChangeListener(e -> {
            lField.setText(String.valueOf(lSlider.getValue()));
            updateFromHLS(++H);
            --H;
        });

        hlsButton.addActionListener(e -> {
            hSlider.setValue(Integer.parseInt(hField.getText()));
            sSlider.setValue(Integer.parseInt(sField.getText()));
            lSlider.setValue(Integer.parseInt(lField.getText()));
            updateFromHLS(0);
        });

        setVisible(true);
    }


    private void updateFromRGB(int coun) {
        try {
            if (coun < 2) {
                int r = rSlider.getValue();
                int g = gSlider.getValue();
                int b = bSlider.getValue();

                // Update CMYK
                int[] cmyk = rgbToCmyk(r, g, b);
                cField.setText(String.valueOf(cmyk[0]));
                cSlider.setValue(cmyk[0]);
                mField.setText(String.valueOf(cmyk[1]));
                mSlider.setValue(cmyk[1]);
                yField.setText(String.valueOf(cmyk[2]));
                ySlider.setValue(cmyk[2]);
                kField.setText(String.valueOf(cmyk[3]));
                kSlider.setValue(cmyk[3]);

                // Update HLS
                int[] hls = rgbToHls(r, g, b);
                hField.setText(String.valueOf(hls[0]));
                hSlider.setValue(hls[0]);
                sField.setText(String.valueOf(hls[1]));
                sSlider.setValue(hls[1]);
                lField.setText(String.valueOf(hls[2]));
                lSlider.setValue(hls[2]);

                updateColorDisplay(r, g, b);
            }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateFromCMYK(int coun) {
        try {
            if (coun < 2) {
                float c = Float.parseFloat(cField.getText()) / 100;
                float m = Float.parseFloat(mField.getText()) / 100;
                float y = Float.parseFloat(yField.getText()) / 100;
                float k = Float.parseFloat(kField.getText()) / 100;

                // Update RGB
                int[] rgb = cmykToRgb(c, m, y, k);
                rSlider.setValue(rgb[0]);
                gSlider.setValue(rgb[1]);
                bSlider.setValue(rgb[2]);

                // Update HLS
                int[] hls = rgbToHls(rgb[0], rgb[1], rgb[2]);
                hField.setText(String.valueOf(hls[0]));
                sField.setText(String.valueOf(hls[1]));
                lField.setText(String.valueOf(hls[2]));

                updateColorDisplay(rgb[0], rgb[1], rgb[2]);
            }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateFromHLS(int coun) {
        try {
            if (coun < 2) {
                float h = Float.parseFloat(hField.getText()) / 360;
                float s = Float.parseFloat(sField.getText()) / 100;
                float l = Float.parseFloat(lField.getText()) / 100;

                // Update RGB
                int[] rgb = hlsToRgb(h, l, s);
                rSlider.setValue(rgb[0]);
                gSlider.setValue(rgb[1]);
                bSlider.setValue(rgb[2]);

                // Update CMYK
                int[] cmyk = rgbToCmyk(rgb[0], rgb[1], rgb[2]);
                cField.setText(String.valueOf(cmyk[0]));
                mField.setText(String.valueOf(cmyk[1]));
                yField.setText(String.valueOf(cmyk[2]));
                kField.setText(String.valueOf(cmyk[3]));

                updateColorDisplay(rgb[0], rgb[1], rgb[2]);
            }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateColorDisplay(int r, int g, int b) {
        colorDisplay.setBackground(new Color(r, g, b));
    }

    private int[] rgbToCmyk(int r, int g, int b) {
        float c = 1 - (r / 255f);
        float m = 1 - (g / 255f);
        float y = 1 - (b / 255f);
        float k = Math.min(c, Math.min(m, y));

        if (k < 1) {
            c = (c - k) / (1 - k);
            m = (m - k) / (1 - k);
            y = (y - k) / (1 - k);
        } else {
            c = m = y = 0;
        }
        return new int[]{(int)(c * 100), (int)(m * 100), (int)(y * 100), (int)(k * 100)};
    }

    private int[] cmykToRgb(float c, float m, float y, float k) {
        int r = (int) ((1 - c) * (1 - k) * 255);
        int g = (int) ((1 - m) * (1 - k) * 255);
        int b = (int) ((1 - y) * (1 - k) * 255);
        return new int[]{r, g, b};
    }

    private int[] rgbToHls(int r, int g, int b) {
        float rN = r / 255f;
        float gN = g / 255f;
        float bN = b / 255f;

        float max = Math.max(rN, Math.max(gN, bN));
        float min = Math.min(rN, Math.min(gN, bN));
        float h, l, s = 0;

        l = (max + min) / 2;

        if (max == min) {
            h = s = 0; // achromatic
        } else {
            float d = max - min;
            s = l <= 0.5 ? d / (max + min) : d / (2 - max - min);

            if (max == rN) {
                h = (gN - bN) / d + (gN < bN ? 6 : 0);
            } else if (max == gN) {
                h = (bN - rN) / d + 2;
            } else {
                h = (rN - gN) / d + 4;
            }
            h /= 6;
        }
        return new int[]{(int)(h * 360), (int)(s * 100), (int)(l * 100)};
    }

    private int[] hlsToRgb(float h, float l, float s) {
        float r, g, b;
        if (s == 0) {
            r = g = b = l; // achromatic
        } else {
            float v2 = l < 0.5 ? l * (1 + s) : (l + s) - (l * s);
            float v1 = 2 * l - v2;

            r = hueToRgb(v1, v2, h + 1f / 3);
            g = hueToRgb(v1, v2, h);
            b = hueToRgb(v1, v2, h - 1f / 3);
        }
        return new int[]{(int)(r * 255), (int)(g * 255), (int)(b * 255)};
    }

    private float hueToRgb(float v1, float v2, float h) {
        if (h < 0) h += 1;
        if (h > 1) h -= 1;
        if (h < 1f / 6) return v1 + (v2 - v1) * 6 * h;
        if (h < 1f / 2) return v2;
        if (h < 2f / 3) return v1 + (v2 - v1) * (2f / 3 - h) * 6;
        return v1;
    }

    private void showError() {
        JOptionPane.showMessageDialog(this, "Invalid input, please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Convert::new);
    }
}