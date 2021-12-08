package ua.hrynko.projectcv.db.dao.interfaces;

import ua.hrynko.projectcv.db.models.Cars;


import java.util.List;


public interface CarsDAO extends AbstractDAO<Cars> {


     Cars findCarToCarsDb(int id);


     List<Cars> findCarSortedUpByName();


     List<Cars> findCarSortedDownByName();


     List<Cars> selectCarsByCategory(String selectByClass);


     List<Cars> findCars();


}


