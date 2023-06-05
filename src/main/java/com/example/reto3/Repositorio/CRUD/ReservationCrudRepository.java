package com.example.reto3.Repositorio.CRUD;

import com.example.reto3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    //Reporte 1
    // SELECT * FROM Reservation Where startDate AFTER fechaA And devolutionDate BEFORE fechaB

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    //Report 2
    //  SELECT * FROM Reservation WHERE status = "valorNecesite";

    public List<Reservation> findAllByStatus(String status);

    //Reporte 3
    //SELECT client, COUNT(client) FROM Reservation GROUP BY client BY COUNT(client) DESC;
    //  Lista de parejas de 2 valores
    //  [ client1 , totalClient1]
    /*
        [client2, totalClient2]
        [client3, totalClient3]
        [client4, totalClient4]
        .......
     */
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationByClient();
}
