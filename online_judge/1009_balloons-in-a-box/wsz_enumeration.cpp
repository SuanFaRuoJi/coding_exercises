//
// Created by Shaoze Wang on 1/12/21.
// https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3450
//

#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

double search(int coor[][3], double * min, bool * visited, int step, int size);
double dist(int x_1, int y_1, int z_1, int x_2, int y_2, int z_2);

int main()
{
    int balloons, test_case = 0;
    cin >> balloons;
    while (balloons) {
        int x_1, y_1, z_1, x_2, y_2, z_2;
        cin >> x_1 >> y_1 >> z_1;
        cin >> x_2 >> y_2 >> z_2;

        int coor[balloons][3], index = 0, result = 0;
        double mins[balloons];
        bool visited[balloons];
        fill(visited, visited+balloons, false);

        while (index < balloons) {
            cin >> coor[index][0] >> coor[index][1] >> coor[index][2];
            mins[index] = min(
                    min(abs(coor[index][0] - x_1), abs(coor[index][0] - x_2)),
                    min(
                            min(abs(coor[index][1] - y_1), abs(coor[index][1] - y_2)),
                            min(abs(coor[index][2] - z_1), abs(coor[index][2] - z_2))
                            )
                    );
            index ++;
        }
        result = round(abs(x_1-x_2) * abs(y_1-y_2) * abs(z_1-z_2) - search(coor, mins, visited, balloons, balloons) * M_PI * 4.0 / 3.0);
        cout << "Box " << (++test_case) << ": " << result << endl;
        cout << endl;
        cin >> balloons;
    }
    return 0;
}

double dist(int x_1, int y_1, int z_1, int x_2, int y_2, int z_2)
{
    return sqrt((x_1-x_2)*(x_1-x_2) + (y_1-y_2)*(y_1-y_2) + (z_1-z_2)*(z_1-z_2));
}

double search(int coor[][3], double * mins, bool * visited, int step, int size)
{
    if (!step) {
        double result = 0;
        for (int i=0; i<size; i++) {
            double r = max(0.0, mins[i]);
            result += r * r * r;
        }
        return result;
    }

    double result = -1;
    for (int i=0; i<size; i++) {
        if (visited[i]) {
            continue;
        }
        double original_min = mins[i];
        visited[i] = true;
        for (int j=0; j<size; j++) {
            if (j == i || !visited[j]) {
                continue;
            }
            mins[i] = min(mins[i],
                          dist(coor[i][0], coor[i][1], coor[i][2],
                               coor[j][0], coor[j][1], coor[j][2]) - mins[j]);
        }
        double local = search(coor, mins, visited, step-1, size);
        result = max(result, local);
        mins[i] = original_min;
        visited[i] = false;
    }

    return result;
}
