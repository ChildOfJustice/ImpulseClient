package execution;

//import FrameSys.FrameSysCore;
//
//public class MainExecutionSys {
//    public static void main(String[] args){
//        FrameSysCore.createFrame();
//
//    }
//}

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;

import java.util.ArrayList;

public class MainExecutionSys extends SimpleApplication {
    Material mat1;

    Texture slash1;
    Texture slash2;

    Texture stand1;
    Texture stand2;
    Texture stand3;

    public ArrayList<Texture> standAnim = new ArrayList<Texture>();

    public MainExecutionSys(){

    }

    String setFile(String name){
         return name + ".png";
    }

    public static void main(String[] args) {

        MainExecutionSys app = new MainExecutionSys();

        AppSettings settings = new AppSettings(true);
        settings.setTitle("My Awesome Game");
        app.setSettings(settings);

        app.start();

    }

    @Override
    public void simpleInitApp() {
        assetManager.registerLocator("I:\\Development\\Java\\Projects\\UdpGame\\ImpulseClientWithEngine\\res\\assets\\BIO\\BRS", FileLocator.class);

        flyCam.setEnabled(false);

        Box backgroundBox = new Box(100f, 100f, 0f);
        Geometry background = new Geometry("background", backgroundBox);


        background.setLocalTranslation(new Vector3f(0f, 0f, 0f));
        Material backgroundMat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");

        backgroundMat.setColor("Color", ColorRGBA.White);
        background.setMaterial(backgroundMat);

        Node pivot1 = new Node("pivot");
        pivot1.attachChild(background);

        rootNode.attachChild(pivot1);





        Box firstRect = new Box(1f, 1f, 0f);
        Geometry blue = new Geometry("Box", firstRect);


        blue.setLocalTranslation(new Vector3f(0f, 0f, 3f));
        mat1 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
//        mat1.setTexture("ColorMap",
//                assetManager.loadTexture("Slash1.png"))
        mat1.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        blue.setQueueBucket(RenderQueue.Bucket.Transparent);
        //mat1.setColor("Color", ColorRGBA.Red);


        stand1 = assetManager.loadTexture(setFile("Stand1"));
        stand2 = assetManager.loadTexture(setFile("Stand2"));
        stand3 = assetManager.loadTexture(setFile("Stand3"));

        slash1 = assetManager.loadTexture(setFile("Slash1"));
        slash2 = assetManager.loadTexture(setFile("Slash2"));

        mat1.setTexture("ColorMap", slash1);
        blue.setMaterial(mat1);

        Node pivot2 = new Node("pivot");
        pivot2.attachChild(blue);

        rootNode.attachChild(pivot2);

//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Blue);
//        geom.setMaterial(mat);

        //rootNode.attachChild(geom);

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        //mat1.setTexture("ColorMap", frame)
    }

}
