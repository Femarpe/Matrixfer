package dam.c1k;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import java.util.HashSet;
import java.util.Set;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    // The window handle
    private static long window = -1;
    private static Set<Integer> mKeymap = new HashSet<>();

    public static boolean isPressedScape() {
        return isPressedKey(GLFW_KEY_ESCAPE);
    }

    public static boolean isPressedKey(int key) {
        return mKeymap.contains(key);
    }

    private static void init(int width, int height) {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(width, height, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (action == GLFW_RELEASE)
                mKeymap.remove(key);
            else
                mKeymap.add(key);
        });
        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    public static void closeWindow() {
        if (window >= 0) {
            glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            glfwFreeCallbacks(window);
            glfwDestroyWindow(window);
            glfwTerminate();
            glfwSetErrorCallback(null).free();
            window = -1;
        }
    }

    public static boolean isClosedWindow() {
        if (window >= 0)
            return glfwWindowShouldClose(window);
        return false;
    }

    public static boolean showImage(int width, int height, int[] pixels) {
        if (window < 0) {
            init(width, height);
            GL.createCapabilities();
        }
        if (glfwWindowShouldClose(window))
            return false;
        if (pixels != null)
            glDrawPixels(width, height, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
        glfwSwapBuffers(window); // swap the color buffers
        glfwPollEvents();
        return true;
    }

}
