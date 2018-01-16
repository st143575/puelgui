package visualisation;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;

import sopias3libraries.CPosition;
import sopias3libraries.LaboratoryCourseThread;
import sopias3libraries.VGraphicObject;

public class LaboratoryCourseVisualisationModul05 extends LaboratoryCourseThread {
	LinkedList<CPosition> WalkedbyPosition;
	LinkedList<CPosition> ObstaclePosition;
	HashMap<CPosition, Boolean> Obstacle;
	LinkedList<VGraphicObject> obstaclesGraphic;
	LaboratoryCourseRobotModul robotermove;
	final double lengthOfObstacle = 320;
	final double widthOfObstacle = 215;

	public LaboratoryCourseVisualisationModul05(LaboratoryCourseRobotModul a) {
		super("Visualisation");
		robotermove = a;
		WalkedbyPosition = new LinkedList<>();
		ObstaclePosition = new LinkedList<>();
		Obstacle = new HashMap<CPosition, Boolean>();
		obstaclesGraphic = new LinkedList<VGraphicObject>();// TODO
															// Auto-generated
															// constructor stub
	}

	@Override
	public void LaboratoryCourseMain() {
		// TODO Auto-generated method stub
		visLib.setTitle("LaboratoryCourseVisualisationModul");
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CPosition StartPosition = robotermove.getStartPosition();
		CPosition EndPosition = robotermove.getGoal();
		// visLib.drawRectangle(Color.black, false, -borderX / 2, borderY / 2,
		// borderX / 2, -borderY / 2);// draw
		// playground
		visLib.drawCircle(Color.RED, false, (int) StartPosition.getX(), (int) StartPosition.getY(), 100);// startpoint
		visLib.drawCircle(Color.RED, false, (int) EndPosition.getX(), (int) EndPosition.getY(), 100);// goalpoint
		visLib.displayText("Modul startet", Color.BLACK);
		visLib.drawRobot(Color.black, (float) StartPosition.getX(), (float) StartPosition.getY(),
				(float) StartPosition.getAngle() - 1);// roboter at the
														// startposition
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CPosition PrePosition = StartPosition;
		int i = -1;
		while (!robotermove.arrived || robotermove.CurrentPosition != EndPosition) {
			WalkedbyPosition.add(robotermove.CurrentPosition);
			this.drawTrajektorie(PrePosition, robotermove.CurrentPosition);
			if (robotermove.isobstacle) { // to judge if this collision with
											// obstacle
				Obstacle.put(robotermove.CurrentPosition, robotermove.obstacleLeft);
				if (i == -1) {// draw the first obstacle
					if (StartPosition.getAngle() == 90 || StartPosition.getAngle() == 270) {
						if (!robotermove.obstacleLeft) {
							VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
									(int) robotermove.CurrentPosition.getX() + 75,
									(int) robotermove.CurrentPosition.getY() + 50,
									(int) robotermove.CurrentPosition.getX() + 300,
									(int) robotermove.CurrentPosition.getY() + 370);
							obstaclesGraphic.add(obstacle);
						} else {
							VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
									(int) robotermove.CurrentPosition.getX() + 75,
									(int) robotermove.CurrentPosition.getY() - 320,
									(int) robotermove.CurrentPosition.getX() + 300,
									(int) robotermove.CurrentPosition.getY());
							obstaclesGraphic.add(obstacle);
						}
					} else {
						if (!robotermove.obstacleLeft) {
							VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
									(int) robotermove.CurrentPosition.getX() - 50,
									(int) robotermove.CurrentPosition.getY() + 225,
									(int) robotermove.CurrentPosition.getX() + 270,
									(int) robotermove.CurrentPosition.getY() + 75);
							obstaclesGraphic.add(obstacle);
						} else {
							VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
									(int) robotermove.CurrentPosition.getX() - 320,
									(int) robotermove.CurrentPosition.getY() + 75,
									(int) robotermove.CurrentPosition.getX(),
									(int) robotermove.CurrentPosition.getY() - 75);
							obstaclesGraphic.add(obstacle);
						}
					}
					// if (!robotermove.obstacleLeft) {
					// VGraphicObject obstacle =
					// visLib.drawRectangle(Color.green, true,
					// (int) robotermove.CurrentPosition.getX() - 50,
					// (int) robotermove.CurrentPosition.getY() + 225,
					// (int) robotermove.CurrentPosition.getX() + 270,
					// (int) robotermove.CurrentPosition.getY() + 75);
					// obstaclesGraphic.add(obstacle);
					// } else {
					// VGraphicObject obstacle =
					// visLib.drawRectangle(Color.green, true,
					// (int) robotermove.CurrentPosition.getX() - 320,
					// (int) robotermove.CurrentPosition.getY() + 75, (int)
					// robotermove.CurrentPosition.getX(),
					// (int) robotermove.CurrentPosition.getY() - 75);
					// obstaclesGraphic.add(obstacle);
					// }
				}

				if (ObstaclePosition.size() != 0) {// to check if the roboter
													// crash the same obstacle
					// boolean tempo = Obstacle.get(ObstaclePosition.get(i));
					double dx = robotermove.CurrentPosition.getX() - ObstaclePosition.get(i).getX();
					double dy = robotermove.CurrentPosition.getY() - ObstaclePosition.get(i).getY();
					if (!(Math.abs(dx) <= lengthOfObstacle && Math.abs(dy) <= widthOfObstacle)) {
						// if (!robotermove.obstacleLeft) {
						// VGraphicObject obstacle =
						// visLib.drawRectangle(Color.green, true,
						// (int) robotermove.CurrentPosition.getX() - 50,
						// (int) robotermove.CurrentPosition.getY() + 225,
						// (int) robotermove.CurrentPosition.getX() + 250,
						// (int) robotermove.CurrentPosition.getY() + 75);
						// obstaclesGraphic.add(obstacle);
						// } else {
						// VGraphicObject obstacle =
						// visLib.drawRectangle(Color.green, true,
						// (int) robotermove.CurrentPosition.getX() - 300,
						// (int) robotermove.CurrentPosition.getY() + 75,
						// (int) robotermove.CurrentPosition.getX(),
						// (int) robotermove.CurrentPosition.getY() - 75);
						// obstaclesGraphic.add(obstacle);
						if (StartPosition.getAngle() == 90 || StartPosition.getAngle() == 270) {
							if (!robotermove.obstacleLeft) {
								VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
										(int) robotermove.CurrentPosition.getX() + 75,
										(int) robotermove.CurrentPosition.getY() + 50,
										(int) robotermove.CurrentPosition.getX() + 300,
										(int) robotermove.CurrentPosition.getY() + 370);
								obstaclesGraphic.add(obstacle);
							} else {
								VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
										(int) robotermove.CurrentPosition.getX() + 75,
										(int) robotermove.CurrentPosition.getY() - 320,
										(int) robotermove.CurrentPosition.getX() + 300,
										(int) robotermove.CurrentPosition.getY());
								obstaclesGraphic.add(obstacle);
							}
						} else {
							if (!robotermove.obstacleLeft) {
								VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
										(int) robotermove.CurrentPosition.getX() - 50,
										(int) robotermove.CurrentPosition.getY() + 225,
										(int) robotermove.CurrentPosition.getX() + 270,
										(int) robotermove.CurrentPosition.getY() + 75);
								obstaclesGraphic.add(obstacle);
							} else {
								VGraphicObject obstacle = visLib.drawRectangle(Color.green, true,
										(int) robotermove.CurrentPosition.getX() - 320,
										(int) robotermove.CurrentPosition.getY() + 75,
										(int) robotermove.CurrentPosition.getX(),
										(int) robotermove.CurrentPosition.getY() - 75);
								obstaclesGraphic.add(obstacle);
							}
						}
					}
				}

				robotermove.setIsobstacle();
				ObstaclePosition.add(robotermove.CurrentPosition);
				i++;
			}
			visLib.drawRobot(Color.black, (float) robotermove.CurrentPosition.getX(),
					(float) robotermove.CurrentPosition.getY(), (float) robotermove.CurrentPosition.getAngle() - 1);
			PrePosition = robotermove.CurrentPosition;
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void drawTrajektorie(CPosition first, CPosition second) {
		visLib.drawPathSegment(Color.black, (int) first.getX(), (int) first.getY(), (int) second.getX(),
				(int) second.getY());
	}

	public LinkedList getWalkedList() {
		return WalkedbyPosition;
	}

	public LinkedList getObstacleList() {
		return ObstaclePosition;
	}

	public LinkedList getGraphice() {
		return obstaclesGraphic;
	}
}
