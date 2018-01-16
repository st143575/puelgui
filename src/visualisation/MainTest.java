package visualisation;

import main.Main;

public class MainTest {

	public static void main(String[] args) {
		LaboratoryCourseRobotModul a = new LaboratoryCourseRobotModul();
	    LaboratoryCourseVisualisationModul05 b = new LaboratoryCourseVisualisationModul05(a);
	    
	    MyFrame mf = new MyFrame();
	    Main main = new Main();
	    main.start();
	}
}