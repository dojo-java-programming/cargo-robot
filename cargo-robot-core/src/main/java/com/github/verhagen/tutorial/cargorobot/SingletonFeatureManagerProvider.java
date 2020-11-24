package com.github.verhagen.tutorial.cargorobot;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.spi.FeatureManagerProvider;
import org.togglz.core.user.NoOpUserProvider;

public class SingletonFeatureManagerProvider implements FeatureManagerProvider {
	private static Logger logger = LoggerFactory.getLogger(SingletonFeatureManagerProvider.class);

	private static FeatureManager featureManager;

	@Override
	public int priority() {
		return 30;
	}

	@Override
	public FeatureManager getFeatureManager() {
		Path workDir = Paths.get(System.getProperty("user.dir"));
		logger.info(workDir.toString());

		if (featureManager == null) {
            featureManager = new FeatureManagerBuilder()
                    .featureEnum(CargoRobotFeatures.class)
//                    .stateRepository(new InMemoryStateRepository())
                    .stateRepository(new FileBasedStateRepository(workDir.resolve("src/main/resources/togglz-features.properties").toFile()))
                    .userProvider(new NoOpUserProvider())
                    .build();
        }

        return featureManager;
	}

}
