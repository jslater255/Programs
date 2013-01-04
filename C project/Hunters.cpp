//
//  Hunters.cpp
//  PvH
//
//  Created by James Slater on 25/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include "Hunters.h"

Hunters::Hunters(){
    
    positionH[0] = 4;
    positionH[1] = 4;
    
    hunters = "|H|";
}

int Hunters::getLonH(){
    return positionH[0];
}
int Hunters::getLatH(){
    return positionH[1];
}
string Hunters::getHLook(){
    return hunters;
}

void Hunters::moveHunter(){
    
    int ran = 0 + (rand() % (int)(1 - 0 + 1));
    //int ran = 0 + static_cast<int>( 1 * (1 - 0) );
    
    
    if ((ran = 0) && positionH[0] > 0) {
        positionH[0] = positionH[0] - 1;
    }
    else if ((ran = 1) && positionH[1] > 0) {
        positionH[1] = positionH[1] - 1;
    }
    cout << ran << "\n";
    cout << positionH[0] << "\n";
    cout << positionH[1] << "\n";
}