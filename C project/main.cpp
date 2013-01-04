//
//  main.cpp
//  PvH
//
//  Created by James Slater on 24/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include "Grid.h"
#include "Player.h"
#include "Hunters.h"


int main(int argc, const char * argv[])
{

    Grid grid = *new Grid();
    Player ply = *new Player();
    //Hunters hunt = *new Hunters();
    
    grid.updateGridP(ply.getLonP(), ply.getLatP(), ply.getPLook());
    grid.outPut();
    char mov;
    while (ply.getLives()>0) {
        
        grid.resetGrid();
        
        std::cout << "Next Move: ";
        std::cin >> mov;
        
        ply.movingP(mov);

        grid.updateGridP(ply.getLatP(), ply.getLonP(), ply.getPLook());
        grid.outPut();
       // hunt.moveHunter();
    }
        
    return 0;
}

