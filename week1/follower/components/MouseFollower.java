package follower.components;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import com.sun.javafx.geom.Vec2d;

import follower.stage.MainStage;

public class MouseFollower implements EventHandler<MouseEvent> {
	private MainStage app;
	private Vec2d coords=new Vec2d();
	
	public MouseFollower(MainStage app) {
		this.app = app;
	}

	public Vec2d getMouseCoords() {
		return coords;
	}
	
	@Override
	public void handle(MouseEvent me) {
		coords.x = me.getSceneX();
		coords.y = me.getSceneY();
	}
}
		