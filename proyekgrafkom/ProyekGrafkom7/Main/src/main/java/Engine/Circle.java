package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Object2D
{
    private double x, y, r, ccx, ccy;
    private int option;
    float rX, rY;
    int poinVertices;
    ArrayList<Float> centerPoint;
    //option 1 Circle
    //option 2 Rectangle Rumus Circle
    //option 3 Triangle Rumus Circle

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double ccx, double ccy, int option, int poinVertices)
    {
        super(shaderModuleDataList, vertices, color);
        this.option = option;
        this.r = r;
        this.ccx = ccx;
        this.ccy = ccy;
        this.poinVertices = poinVertices;
        if(option == 1)
            createCircle();
        else if(option == 2)
            createRectangle();
        else if(option == 3)
            createTriangle();
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, double ccx, double ccy, float rX, float rY)
    {
        super(shaderModuleDataList, vertices, color);
        this.r = r;
        this.ccx = ccx;
        this.ccy = ccy;
        this.rX = rX;
        this.rY= rY;
        createEllipse(this.rX,this.rY);
    }
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, ArrayList<Float> centerPoint, float rX, float rY)
    {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.r = r;
        this.rX = rX;
        this.rY= rY;
    }
    public void createCircle()
    {
        vertices.clear();

        for (double i = 0; i < 360; i+=0.01)
        {
            x = ccx + r * (float)Math.cos(Math.toRadians(i));
            y = ccy + r * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }

    public void createRectangle()
    {
        vertices.clear();

        for (double i = 45; i < 405; i+=90)
        {
            x = ccx + r * (float)Math.cos(Math.toRadians(i));
            y = ccy + r * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }

    public void createTriangle()
    {
        vertices.clear();

        for (double i = 90; i < 360; i+=120)
        {
            x = ccx + r * (float)Math.cos(Math.toRadians(i));
            y = ccy + r * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }
    public void createEllipse(double panjang, double lebar)
    {
        vertices.clear();

        for (double i = 0; i < 360; i+=0.01)
        {
            x = ccx + (r/panjang) * (float)Math.cos(Math.toRadians(i));
            y = ccy + (r/lebar) * (float)Math.sin(Math.toRadians(i));
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }
        setupVAOVBO();
    }
    @Override
    public void draw()
    {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
    }

    public void MoveObj(double ccx,double ccy) {
        this.ccx = ccx;
        this.ccy = ccy;
        createRectangle();
        setupVAOVBO();
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getCcx() {
        return ccx;
    }

    public void setCcx(double ccx) {
        this.ccx = ccx;
    }

    public double getCcy() {
        return ccy;
    }

    public void setCcy(double ccy) {
        this.ccy = ccy;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getPoinVertices() {
        return poinVertices;
    }

    public void setPoinVertices(int poinVertices) {
        this.poinVertices = poinVertices;
    }
}

