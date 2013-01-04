//
//  Grid.cpp
//  PvH
//
//  Created by James Slater on 24/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include "Grid.h"

Grid::Grid(){
    setGridUp();
}

void Grid::outPut(){
    for (int i = 0; i<5; i++) {
        std::cout << gridT[i];
    }
    std::cout << "\n";
    
    for (int i = 0; i<5; i++) {
        std::cout << grid1[i];
    }
    std::cout << "\n";
    for (int i = 0; i<5; i++) {
        std::cout << grid2[i];
    }
    std::cout << "\n";
    for (int i = 0; i<5; i++) {
        std::cout << grid3[i];
    }
    std::cout << "\n";
    for (int i = 0; i<5; i++) {
        std::cout << grid4[i];
    }
    std::cout << "\n";
    for (int i = 0; i<5; i++) {
        std::cout << grid5[i];
    }
    std::cout << "\n";

}

void Grid::setGridUp(){
    for (int i = 0; i<6; i++) {
        gridT[i] = " _ ";
    }
    for (int i = 0; i<6; i++) {
        grid1[i] = "|_|";
    }
    
    for (int i = 0; i<6; i++) {
        grid2[i] = "|_|";
    }
    
    for (int i = 0; i<6; i++) {
        grid3[i] = "|_|";
    }
    
    for (int i = 0; i<6; i++) {
        grid4[i] = "|_|";
    }
    
    for (int i = 0; i<6; i++) {
        grid5[i] = "|_|";
    }
}

void Grid::updateGridP(int lon, int lat, std::string playerL){
    if (lat == 0) {
        if (lon == 0) {
            grid1[0] = playerL;
        }
        else if (lon == 1) {
            grid1[1] = playerL;
        }
        else if (lon == 2) {
            grid1[2] = playerL;
        }
        else if (lon == 3) {
            grid1[3] = playerL;
        }
        else if (lon == 4) {
            grid1[4] = playerL;
        }
        else if (lon == 5) {
            grid1[5] = playerL;
        }
    }
    else if (lat == 1) {
        if (lon == 0) {
            grid2[0] = playerL;
        }
        else if (lon == 1) {
            grid2[1] = playerL;
        }
        else if (lon == 2) {
            grid2[2] = playerL;
        }
        else if (lon == 3) {
            grid2[3] = playerL;
        }
        else if (lon == 4) {
            grid2[4] = playerL;
        }
        else if (lon == 5) {
            grid2[5] = playerL;
        }        
    }
    else if (lat == 2) {
        if (lon == 0) {
            grid3[0] = playerL;
        }
        else if (lon == 1) {
            grid3[1] = playerL;
        }
        else if (lon == 2) {
            grid3[2] = playerL;
        }
        else if (lon == 3) {
            grid3[3] = playerL;
        }
        else if (lon == 4) {
            grid3[4] = playerL;
        }
        else if (lon == 5) {
            grid3[5] = playerL;
        }       
    }
    else if (lat == 3) {
        if (lon == 0) {
            grid4[0] = playerL;
        }
        else if (lon == 1) {
            grid4[1] = playerL;
        }
        else if (lon == 2) {
            grid4[2] = playerL;
        }
        else if (lon == 3) {
            grid4[3] = playerL;
        }
        else if (lon == 4) {
            grid4[4] = playerL;
        }
        else if (lon == 5) {
            grid4[5] = playerL;
        }       
    }
    else if (lat == 4) {
        if (lon == 0) {
            grid5[0] = playerL;
        }
        else if (lon == 1) {
            grid5[1] = playerL
            ;
        }
        else if (lon == 2) {
            grid5[2] = playerL;
        }
        else if (lon == 3) {
            grid5[3] = playerL;
        }
        else if (lon == 4) {
            grid5[4] = playerL;
        }
        else if (lon == 5) {
            grid5[5] = playerL;
        }       
    }

}

void Grid::resetGrid(){
    for (int i = 0; i<6; i++) {
        grid1[i] = "|_|";
    }
    for (int i = 0; i<6; i++) {
        grid2[i] = "|_|";
    }
    for (int i = 0; i<6; i++) {
        grid3[i] = "|_|";
    }
    for (int i = 0; i<6; i++) {
        grid4[i] = "|_|";
    }
    for (int i = 0; i<6; i++) {
        grid5[i] = "|_|";
    }

}