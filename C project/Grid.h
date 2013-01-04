//
//  Grid.h
//  PvH
//
//  Created by James Slater on 24/07/2012.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#ifndef PvH_Grid_h
#define PvH_Grid_h

#include <iostream>

class Grid{
    
private:
    std::string gridT[7];
    std::string grid1[7];
    std::string grid2[7];
    std::string grid3[7];
    std::string grid4[7];
    std::string grid5[7];

public:
    Grid();
    void outPut();
    void updateGridP(int, int, std::string);
    void updateGridH(int, int, std::string);
    void resetGrid();
    
private:
    void setGridUp();
};

#endif
