//
//  Player.cpp
//  PvH
//
//  Created by James Slater on 24/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include "Player.h"
#include <iostream>

using namespace std;

Player::Player(){
    player = "|P|"; 
    positionP[0] = 0;
    positionP[1] = 0;
    lives = 5;
}

void Player::movingP(char pos){
    if ((pos == 'r') && (positionP[1] < 4)) {
        positionP[1] = positionP[1]+1;
    }
    else if((pos == 'l') && (positionP[1] > 0)){
        positionP[1] = positionP[1]-1;
        
    }
    else if((pos == 'u') && (positionP[0] > 0)){
        positionP[0] = positionP[0]-1;
        
    }
    else if((pos == 'd') && (positionP[0] < 4)){
        positionP[0] = positionP[0]+1;
        
    }
    else{}
}

int Player::getLonP(){
    return positionP[0];
}
int Player::getLatP(){
    return positionP[1];
}
int Player::getLives(){
    return lives;
}
string Player::getPLook(){
    return player;
}
