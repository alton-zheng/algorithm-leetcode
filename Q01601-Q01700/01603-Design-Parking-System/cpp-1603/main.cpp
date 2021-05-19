#include <iostream>
#include <vector>
using namespace std;


/// Simulation
/// Time Complexity: O(1)
/// Space Complexity: O(1)
class ParkingSystem {
public:
    int b, m, s;
    ParkingSystem(int big, int medium, int small): b(big), m(medium), s(small) {}

    bool addCar(int carType) {
        if (carType == 1) {
            if (b > 0) {
                b--;
                return true;
            }
        } else if (carType == 2) {
            if (m > 0) {
                m--;
                return true;
            }
        } else if (carType == 3) {
            if (s > 0) {
                s--;
                return true;
            }
        }
        return false;
    }
};