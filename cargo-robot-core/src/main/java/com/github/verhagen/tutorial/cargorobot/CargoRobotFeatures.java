package com.github.verhagen.tutorial.cargorobot;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum CargoRobotFeatures implements Feature {

	@Label("Makes derailment impossible")
	FEATURE_CRANE_SAFE_MOVEMENT,

	@Label("Makes too high box stacking impossible")
	FEATURE_CRANE_SAFE_STACKING_OF_BOXES;

	public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
