class ParkingSystem {
    int bigLimit;
    int mediumLimit;
    int smallLimit;

    public ParkingSystem(int big, int medium, int small) {
        this.bigLimit = big;
        this.mediumLimit = medium;
        this.smallLimit = small;
    }

    public boolean addCar(int carType) {
        if((carType == 1 && bigLimit == 0) || (carType == 2 && mediumLimit == 0) || (carType == 3 && smallLimit == 0)) return false;
        if(carType == 1) bigLimit--;
        if(carType == 2) mediumLimit--;
        if(carType == 3) smallLimit--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */