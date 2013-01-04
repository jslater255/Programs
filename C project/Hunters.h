//
//  Hunters.h
//  PvH
//
//  Created by James Slater on 25/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#ifndef PvH_Hunters_h
#define PvH_Hunters_h

#include <iostream>
#include <string>

using namespace std;

class Hunters{
    
    string hunters;
    
    int positionH[2];
    
public:
    Hunters();
    int getLonH();
    int getLatH();
    string getHLook();
    void moveHunter();
    
};

#endif
