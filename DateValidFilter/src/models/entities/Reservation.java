package models.entities;

import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

public class Reservation {
    private Integer roomNumber;
    private Date chekin;

    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reservation(Integer roomNumber, Date chekin, Date checkOut) {
        this.roomNumber = roomNumber;
        this.chekin = chekin;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
//foi retirado o set para evitar que as datas fossem manipuladas
    public Date getChekin() {
        return chekin;
    }

    public Date getCheckOut() {
        return checkOut;
    }
//calcular a diferenca entre datas
    public long duration(){
        //sera pego a diferenca entre as duas datas em mile segundos
        long diif = checkOut.getTime()-chekin.getTime();
        //agora sera convertido mile segundos para dias
        return TimeUnit.DAYS.convert(diif,TimeUnit.MICROSECONDS);
    }

    //vai receber duas datas novas e atualizar
    public void updaDates(Date chekin,Date checkOut){
        this.chekin =chekin;
        this.checkOut = checkOut;
    }
    //realizado tratamento das datas como solicitado no exercicio
    @Override
    public String toString() {
        return  "Room"
                + roomNumber
                + ", check-in"
                + sdf.format(chekin)
                + ", Check-out"
                + sdf.format(checkOut)
                +", "
                + duration()
                +" nights";

    }
}
