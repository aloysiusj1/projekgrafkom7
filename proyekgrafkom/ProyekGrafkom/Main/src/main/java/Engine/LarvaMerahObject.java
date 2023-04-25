package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class LarvaMerahObject extends Circle3D {
    float rZ;
    int stackCount;
    int sectorCount;

    public LarvaMerahObject(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, ArrayList<Float> centerPoint, float rX, float rY, float rZ, int stackCount, int sectorCount, int option) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;

        if (option == 0) {
            LMO_Badan();
        } else if (option == 1) {
            LMO_AntenaBody();
        } else if (option == 2){
            LMO_BadanBawah();
        }else if (option == 3){
            LMO_Mata();
        }else if (option == 4){
            LMO_Mouth();
        }else if (option == 5){
            LMO_Kumis();
        } else if (option == 6) {
            LMO_Triangle();
        }
        setupVAOVBO();
    }

    public void LMO_Badan() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 180) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 180) {
                float x = rX * (float) (Math.cos(v) * Math.cos(u));
                float y = rY * (float) (Math.cos(v) * Math.sin(u));
                float z = rZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }
    public void LMO_AntenaBody() {
        vertices.clear();
        float rxTemp = rX, ryTemp = rY;
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double i = 0; i <= 360; i += 0.05f) {
            float x = centerPoint.get(0) + rxTemp * (float) Math.cos(Math.toRadians(i));
            float y = centerPoint.get(1) + ryTemp * (float) Math.sin(Math.toRadians(i));

            temp.add(new Vector3f(x, y, rZ));
            temp.add(new Vector3f(x, y, -rZ));
        }
        vertices = temp;
    }
    public void LMO_BadanBawah(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= Math.PI*2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI*2; u+=Math.PI/60){
                float x = (rZ + rX * (float)(Math.cos(v))) * (float)Math.cos(u);
                float y = (rZ + rY * (float)(Math.cos(v))) * (float)Math.sin(u);
                float z = rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void LMO_Mata(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= Math.PI*2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI*2; u+=Math.PI/60){
                float x = (rZ + rX * (float)(Math.cos(v))) * (float)Math.cos(u);
                float y = (rZ + rY * (float)(Math.cos(v))) * (float)Math.sin(u);
                float z = rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void LMO_Mouth() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float x, y, z;
        float r1 = rX * 0.8f;
        float r2 = rY * 0.5f;

        for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 180) {
            x = r1 * (float) (Math.cos(u));
            y = r2 * (float) (Math.sin(u)) + rY * 0.5f;
            z = 0.0f;
            temp.add(new Vector3f(x, y, z));
        }

        vertices = temp;
    }
    public void LMO_Kumis() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float x, y, z;
        float h = rY * 0.5f;
        float w = rX * 0.4f;

        // Kiri atas
        x = -w;
        y = h;
        z = 0.0f;
        temp.add(new Vector3f(x, y, z));

        // Kanan atas
        x = w;
        y = h;
        z = 0.0f;
        temp.add(new Vector3f(x, y, z));

        // Kanan bawah
        x = w;
        y = -h;
        z = 0.0f;
        temp.add(new Vector3f(x, y, z));

        // Kiri bawah
        x = -w;
        y = -h;
        z = 0.0f;
        temp.add(new Vector3f(x, y, z));

        vertices = temp;
    }
    public void LMO_Triangle() {
        vertices.clear();

        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 0
        temp.x = centerPoint.get(0) + rX / 2.0f;
        temp.y = 0;
        temp.z = centerPoint.get(2) + rZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        //TITIK 1
        temp.x = centerPoint.get(0) + rX;
        temp.y = 0;
        temp.z = 0;
        tempVertices.add(temp);
        temp = new Vector3f();

        //TITIK 2
        temp.x = 0;
        temp.y = 0;
        temp.z = 0;
        tempVertices.add(temp);
        temp = new Vector3f();

        //TITIK 3
        temp.x = centerPoint.get(0) + rX / 2.0f;
        temp.y = centerPoint.get(1) + rY;
        temp.z = centerPoint.get(2) + rZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        //TITIK 4
        temp.x = centerPoint.get(0) + rX;
        temp.y = centerPoint.get(1) + rY;
        temp.z = 0;
        tempVertices.add(temp);
        temp = new Vector3f();

        //TITIK 5
        temp.x = 0;
        temp.y = centerPoint.get(1) + rY;
        temp.z = 0;
        tempVertices.add(temp);
        temp = new Vector3f();



        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(0));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(5));
    }
    public void draw(Camera camera, Projection projection){
        drawSetup(camera,projection);
        // Draw vertices
        glLineWidth(1);
        glPointSize(1);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        for(Object child : getChildObject()){
            child.draw(camera,projection);
        }
    }
    public float getrZ() {
        return rZ;
    }

    public void setrZ(float rZ) {
        this.rZ = rZ;
    }

}