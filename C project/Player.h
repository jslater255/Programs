//
//  Player.h
//  PvH
//
//  Created by James Slater on 24/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#ifndef PvH_Player_h
#define PvH_Player_h

#include <iostream>
class Player{
    
    std::string player;
    int positionP[2];
    int lives;
    
public:
    Player();
    void movingP(char);
    int getLonP();
    int getLatP();
    int getLives();
    std::string getPLook();
};
#endif
