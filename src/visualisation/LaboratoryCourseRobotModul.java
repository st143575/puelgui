package visualisation;

import sopias3libraries.CExceptionAngleOutOfRange;
import sopias3libraries.CExceptionCollision;
import sopias3libraries.CExceptionGeneralClientServerCommunicationError;
import sopias3libraries.CExceptionGeneralServerRobotCommunicationError;
import sopias3libraries.CExceptionNoOwnRobotConnectedOrConnectionLost;
import sopias3libraries.CPosition;
import sopias3libraries.LaboratoryCourseThread;
import sopias3libraries.RobotLibrary;

public class LaboratoryCourseRobotModul extends LaboratoryCourseThread {
	CPosition StartPosition;
	CPosition CurrentPosition;
	CPosition goal;
	CPosition position;
	boolean arrived = false;
	boolean isobstacle = false;
	boolean obstacleLeft;
	final int lengthOfRobot = 150;
	

	public LaboratoryCourseRobotModul() {
		super("Prototyp");
	}

	@Override
	public void LaboratoryCourseMain() {
		robotLib.connectServer("127.0.0.1", 60000); // connect to the
		// control-server
		System.out.println("Connect");
		try {
			robotLib.connectOwnRobot(0, -1750, 0, 90);
			StartPosition = new CPosition(-1750, 0, 90);

			// Thread.sleep(10*1000);
		} catch (CExceptionGeneralClientServerCommunicationError e) {
			System.out.println("Exception: " + e.getMessage());
		} // connect to the robot number 0

		goal = new CPosition(196, 280, 90);

		while (true) {

			CExceptionCollision collision = driveTo(goal.getX(), goal.getY());

			if (collision != null) {
				isobstacle = true;
				position = collision.getPosition();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else
				break;

			try {

				CurrentPosition = robotLib.drive(-50);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// boolean obstacleLeft;

				if (robotLib.getSensor().getSensorLF() < robotLib.getSensor().getSensorRF()) {

					boolean b = true;
					int lastDist = -1;
					int ttl = 20;
					while (b) {

						robotLib.rotate(-5);

						int newDist = robotLib.getSensor().getSensorL();

						if ((newDist > lastDist && newDist < 100 && lastDist > -1) || ttl == 0)
							b = false;
						lastDist = newDist;
						ttl--;
					}

					obstacleLeft = true;

				} else {

					boolean c = true;
					int lastDist = -1;
					int ttl = 20;
					while (c) {

						robotLib.rotate(5);

						int newDist = robotLib.getSensor().getSensorR();

						if ((newDist > lastDist && newDist < 100 && lastDist > -1) || ttl == 0)
							c = false;
						lastDist = newDist;
						ttl--;
					}
					obstacleLeft = false;

				}

				if (obstacleLeft) {
					while (robotLib.getSensor().getSensorL() < 30) {

						CurrentPosition = robotLib.drive(10);

					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					CurrentPosition = robotLib.drive(lengthOfRobot);

					// System.out.println(CurrentPosition.getX() + " " +
					// CurrentPosition.getY());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					while (robotLib.getSensor().getSensorR() < 30) {

						CurrentPosition = robotLib.drive(10);

					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CurrentPosition = robotLib.drive(lengthOfRobot);

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} catch (CExceptionCollision | CExceptionNoOwnRobotConnectedOrConnectionLost
					| CExceptionGeneralClientServerCommunicationError | CExceptionGeneralServerRobotCommunicationError
					| CExceptionAngleOutOfRange e) {
				// e.printStackTrace();
				System.out.println("Fehler beim Umfahren, probiere wieder direkte Route.");
			}
		}
		// when LaboratoryCourseMain is finished, the Thread dies
		// end of example code
	}

	public CExceptionCollision driveTo(double x, double y) {
		try {

			position = robotLib.drive(0);
			while (Math.abs(position.getX() - x) > 5 || Math.abs(position.getY() - y) > 5) {

				position = robotLib.drive(0);
				
				double dx = x - position.getX();
				double dy = y - position.getY();

				int strecke = (int) Math.sqrt(dx * dx + dy * dy);

				int winkel = (int) (Math.atan2(dy, dx) / Math.PI * 180) + 90;

				robotLib.rotate((winkel - (int) position.getAngle()) % 360);

				position = robotLib.drive(strecke);

				CurrentPosition = position;

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (CExceptionNoOwnRobotConnectedOrConnectionLost | CExceptionGeneralClientServerCommunicationError
				| CExceptionAngleOutOfRange | CExceptionGeneralServerRobotCommunicationError e) {
			e.printStackTrace();
			return null;
		} catch (CExceptionCollision e) {

			// CPosition tempo = new CPosition(e.getPosition().getY() - 100,
			// e.getPosition().getX() + 700,
			// e.getPosition().getAngle());

			try {
				CurrentPosition = robotLib.drive(0);
			} catch (CExceptionCollision | CExceptionNoOwnRobotConnectedOrConnectionLost
					| CExceptionGeneralClientServerCommunicationError
					| CExceptionGeneralServerRobotCommunicationError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return e;
		}

		arrived = true;
		System.out.println("Goal reached!");
		return null;

	}

	public CPosition getStartPosition() {
		return StartPosition;
	}

	public CPosition getGoal() {
		return goal;
	}

	public boolean getArrived() {
		return arrived;
	}

	public CPosition getCurrentPosition() {
		return CurrentPosition;
	}

	public void setIsobstacle() {
		isobstacle = false;
	}

}
