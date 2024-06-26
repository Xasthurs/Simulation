package Simulation2D.Actions;

import Simulation2D.Entities.*;
import Simulation2D.EntityMap;
import Simulation2D.CreaturesStatusRender;

import java.util.Set;


public class Action {
    CreaturesStatusRender statusRender = new CreaturesStatusRender();

    private void fillMapRandomly(EntityMap entityMap) {
        SpawnGrass spawnGrass = new SpawnGrass();
        spawnGrass.fillWithGrass(entityMap);

        SpawnRock spawnRock = new SpawnRock();
        spawnRock.fillWithRocks(entityMap);

        SpawnTree spawnTree = new SpawnTree();
        spawnTree.fillWithTrees(entityMap);

        SpawnHerbivore spawnHerbivore = new SpawnHerbivore();
        spawnHerbivore.fillWithHerbivores(entityMap);

        SpawnPredator spawnPredator = new SpawnPredator();
        spawnPredator.fillWithPredators(entityMap);
    }

    public EntityMap initActions(EntityMap entityMap) {
        fillMapRandomly(entityMap);
        return entityMap;
    }


    public void turnActions(EntityMap entityMap) {
        Set<Creature> creatures = statusRender.scanCreaturesInMap(entityMap);
        for (Creature creature : creatures) {
            if(!entityMap.containsEntity(creature)){
                continue;
            }
            for (int i = 0; i < creature.getMovementSpeed(); i++) {
                creature.makeMove(creature.getCoordinates(), entityMap);
            }
        }
    }
}