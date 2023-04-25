package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class SphereMike extends CircleMike{

    float radiusY, radiusZ;
    int sectorCount, stackCount;
    int ibo;
    List<Integer> index;
    ArrayList<Float> centerPoint = new ArrayList<>();

    public SphereMike(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerX, float centerY,
                  float radius, float radiusY, float radiusZ, int sectorCount, int stackCount, int objekganda) {
        super(shaderModuleDataList, vertices, color, centerX, centerY, radius);
        this.radiusY = radiusY;
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;

        if(objekganda == 0){
            createSphere();
        }else
        if(objekganda == 3){
            createElipsoid();
        }else
        if(objekganda == 2){
            createEllipticParaboloid();
        }else
        if(objekganda == 1){
            createHyperParaboloid();
        }
        centerPoint.add(0f);
        centerPoint.add(0f);
        centerPoint.add(0f);
//        createSphere();
//        createElipsoid();
//        createHyperboloid1();
//        createHyperboloid2();
//        createBox();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperParaboloid();
        setupVAOVBO();
    }

    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

//        // titik persegi
//        for (int i =0;i<= stackCount;i++){
//
//        }

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);

    }

    public void createElipsoid(){
//        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

    }

    public void createHyperboloid1(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(1/Math.cos(v) * Math.cos(u));
                float y = 0.1f * (float)(1/Math.cos(v) * Math.sin(u));
                float z = 0.1f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(Math.tan(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.tan(v) * Math.sin(u));
                float z = 0.1f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = -0.1f * (float) (Math.tan(v) * Math.cos(u));
                float y = -0.1f * (float) (Math.tan(v) * Math.sin(u));
                float z = -0.1f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
            // yg ini tadi disuru -1 trs jadi atas bawah
        }

        vertices = temp;
    }

    public void createEllipticCone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.cos(u));
                float y = 0.1f * (float)((v) * Math.sin(u));
                float z = 0.1f * (float)((v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createEllipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.cos(u));
                float z = 0.1f * (float)((v) * Math.sin(u));
                float y = -0.1f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHyperParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = Math.PI/2; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.tan(u));
                float y = 0.1f * (float)((v) * 1/Math.cos(u));
                float z = 0.1f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }


    public void createBox() {
        //Titik 1
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        temp.x = centerPoint.get(0) - radius / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //2
        temp.x = centerPoint.get(0) + radius / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //3
        temp.x = centerPoint.get(0) + radius / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //4
        temp.x = centerPoint.get(0) - radius / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //5
        temp.x = centerPoint.get(0) - radius / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //6
        temp.x = centerPoint.get(0) + radius / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //7
        temp.x = centerPoint.get(0) + radius / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();
        //8
        temp.x = centerPoint.get(0) - radius / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;

        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //Kotak Belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //Kotak Depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //Kotak Kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //Kotak Kanan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //Kotak Bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

//    public void draw() {
//        drawSetup();
//
//        glLineWidth(1);
//        glPointSize(0);
//        glDrawArrays(GL_LINES, 0, vertices.size());
//    }
}