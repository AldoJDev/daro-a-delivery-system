import React, { useEffect, useState } from "react";
import "../css/Driver.css";

/*  FontAwesomeIcon */
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleDown, faAngleLeft, faAngleRight, faAngleUp, faAnglesLeft, faAnglesRight } from "@fortawesome/free-solid-svg-icons";

function Driver(){
    const [inputDriver, setInputDriver] = useState("");
    const [startCounter, setStartCounter] = useState(0);
    const [endCounter, setEndCounter] = useState(8);
    const [pageCounter, setPageCounter] = useState(1);

    const [dataDrivers, setDataDrivers] = useState([
        {    
        "id": "8444b786-041c-4496-8fb0-3f8f9f411ebc",
        "warehouse": {
          "id": "ddf7c88f-42e6-4db6-9093-c99851035a13",
          "name": "Centro de distribuição 2",
          "city": "Campinas",
          "state": "São Paulo",
          "latitude": 0,
          "longitude": 0
        },
        "name": "Paulo Santos Rocha",
        "shift_start": "07:00:00",
        "shift_end": "17:00:00",
        "break_start": "10:00:00",
        "break_end": "11:00:00",
        "speed": 45
        },
        {    
        "id": "8444b786-041c-4496-8fb0-3f8f9f411ebc",
        "warehouse": {
            "id": "ddf7c88f-42e6-4db6-9093-c99851035a13",
            "name": "Centro de distribuição 1",
            "city": "Campinas",
            "state": "São Paulo",
            "latitude": 0,
            "longitude": 0
        },
        "name": "Paulo Santos Rocha",
        "shift_start": "07:00:00",
        "shift_end": "17:00:00",
        "break_start": "10:00:00",
        "break_end": "11:00:00",
        "speed": 45
        },
    ]);

    const [dataDriversBackUp] = useState(dataDrivers);

    const changeInputDriver = (event) => {
        var aux = event.target.value;
        setInputDriver(aux);
    }

    const handleWarehouseDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.warehouse.name < b.warehouse.name)
                  return -1;
                else if (a.warehouse.name > b.warehouse.name) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.warehouse.name > b.warehouse.name)
                  return -1;
                if (a.warehouse.name < b.warehouse.name) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleNameDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.name < b.name)
                  return -1;
                else if (a.name > b.name) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.name > b.name)
                  return -1;
                if (a.name < b.name) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleShiftStartDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.shift_start < b.shift_start)
                  return -1;
                else if (a.shift_start > b.shift_start) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.shift_start > b.shift_start)
                  return -1;
                if (a.shift_start < b.shift_start) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleShiftEndDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.shift_end < b.shift_end)
                  return -1;
                else if (a.shift_end > b.shift_end) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.shift_end > b.shift_end)
                  return -1;
                if (a.shift_end < b.shift_end) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleBreakStartDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.break_start < b.break_start)
                  return -1;
                else if (a.break_start > b.break_start) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.break_start > b.break_start)
                  return -1;
                if (a.break_start < b.break_start) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleBreakEndDriver = (number) => {
        let sortedDrivers;

        if(number == 0){ // ordenação comum
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.break_end < b.break_end)
                  return -1;
                else if (a.break_end > b.break_end) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedDrivers = [...dataDrivers].sort((a, b) => {
                if (a.break_end > b.break_end)
                  return -1;
                if (a.break_end < b.break_end) 
                  return 1;
                return 0;
              });
        }

        setDataDrivers(sortedDrivers);
    }

    const handleSpeedDriver = () => {
        let sortedDrivers = [...dataDrivers].sort((a, b) => a.speed - b.speed);
        setDataDrivers(sortedDrivers);
    }

    /* Pagination functions */
    const handleStartDriver = () => {
        setPageCounter(1);
        setStartCounter(0);
        setEndCounter(8);
    }
  
    const handleEndDriver = () => {
        const pages = Math.ceil(dataDriversBackUp.length / 8);
        const endPageIndex = (pages - 1) * 8;
  
        setPageCounter(pages);
        setStartCounter(endPageIndex);
        setEndCounter(dataDriversBackUp.length);
    }
  
    const handlePreviousDriver = () => {
        if (pageCounter > 1) { // se já não está na primeira página
  
          let newStartCounter;
          if (startCounter - 8 < 0)
            newStartCounter = 0;
          
          else
            newStartCounter = startCounter - 8;
  
          const newEndCounter = newStartCounter + 8;
  
          setPageCounter(pageCounter - 1);
          setStartCounter(newStartCounter);
          setEndCounter(newEndCounter);
        }
    }
      
    const handleNextDriver = () => {
        const pages = Math.ceil(dataDriversBackUp.length / 8);
  
        if (pageCounter < pages) { // se não está na última página
          const newStartCounter = endCounter;
          const newEndCounter = Math.min(endCounter + 8, dataDriversBackUp.length);
  
          setPageCounter(pageCounter + 1);
          setStartCounter(newStartCounter);
          setEndCounter(newEndCounter);
        }
    }

    useEffect(() => {
        if(inputDriver != ""){
            const aux = dataDriversBackUp.filter(data => data.name.includes(inputDriver));
            setDataDrivers(aux);
        }
        
        else{
            setDataDrivers(dataDriversBackUp);
        }
    }, [inputDriver]);

    useEffect(() => {
        const paginatedItems = dataDriversBackUp.slice(startCounter, endCounter); // cria vetor com os 8 dados
        setDataDrivers(paginatedItems);
    }, [])
  
    useEffect(() => {
        const paginatedItems = dataDriversBackUp.slice(startCounter, endCounter); // cria vetor com os 8 dados
        setDataDrivers(paginatedItems);
    }, [startCounter, endCounter])

    return(
        <div className="container-master-driver">
            <div className="container-total-driver">

                <div className="container-left-driver">

                    <div className="search-driver">
                        <p className="p-search-driver">Buscar pelo nome do motorista</p>
                        <input type="text" placeholder="Buscar por nome" onChange={changeInputDriver} className="input-search-driver"/>
                    </div>

                    <div className="buttons-driver">
                        <button className="btn-driver">Voltar</button>
                    </div>

                </div>

                <div className="container-right-driver">

                    <div className="grid-driver">
                        <table className="table-driver">

                            <tr className="tr-driver">
                                <th className="filter-driver th-driver">
                                    Centro Operante
                                    <div className="icons">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleWarehouseDriver(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleWarehouseDriver(1)}/>
                                    </div>
                                </th>

                                <th className="filter-driver th-driver">
                                    Nome
                                    <div className="icons">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleNameDriver(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleNameDriver(1)}/>
                                    </div>
                                </th>

                                <th className="filter-driver th-driver">
                                    Início do expediente
                                    <div className="icons">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleShiftStartDriver(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleShiftStartDriver(1)}/>
                                    </div>
                                </th>

                                <th className="filter-driver th-driver">
                                    Início do intervalo
                                    <div className="icons">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleBreakStartDriver(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleBreakStartDriver(1)}/>
                                    </div>
                                </th>

                                <th className="filter-driver th-driver">
                                    Fim do intervalo
                                    <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleBreakEndDriver(0)}/>
                                    <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleBreakEndDriver(1)}/>
                                </th>

                                <th className="filter-driver th-driver">
                                    Fim do expediente
                                    <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleShiftEndDriver(0)}/>
                                    <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleShiftEndDriver(1)}/>
                                </th>

                                <th className="filter-driver th-driver">
                                    Velocidade
                                    <FontAwesomeIcon icon={faAngleUp} className="UpDownDriver" onClick={() => handleSpeedDriver(0)}/>
                                    <FontAwesomeIcon icon={faAngleDown} className="DownUpDriver" onClick={() => handleSpeedDriver(1)}/>
                                </th>
                            </tr>

                            {dataDrivers.map((dataDrivers) => (
                                <tr className="tr-driver">
                                    <td className="td-driver">{dataDrivers.warehouse.name}</td>
                                    <td className="td-driver">{dataDrivers.name}</td>
                                    <td className="td-driver">{dataDrivers.shift_start}</td>
                                    <td className="td-driver">{dataDrivers.break_start}</td>
                                    <td className="td-driver">{dataDrivers.break_end}</td>
                                    <td className="td-driver">{dataDrivers.shift_end}</td>
                                    <td className="td-driver">{dataDrivers.speed}</td>
                                </tr>
                            ))}

                        </table>
                    </div>

                    <div className="pagination-driver">
                      <button className="pagination-button-driver" onClick={handleStartDriver}>
                        <FontAwesomeIcon icon={faAnglesLeft}/>
                      </button>

                      <button className="pagination-button-driver" onClick={handlePreviousDriver}>
                        <FontAwesomeIcon icon={faAngleLeft}/>
                      </button>

                      <button className="pagination-button-driver" onClick={handleNextDriver}>
                        <FontAwesomeIcon icon={faAngleRight}/>
                      </button>

                      <button className="pagination-button-driver" onClick={handleEndDriver}>
                        <FontAwesomeIcon icon={faAnglesRight}/>
                      </button>
                    </div>

                    <p>{pageCounter} / {Math.ceil(dataDriversBackUp.length / 8)}</p>

                </div>

            </div>
        </div>
    );
}

export default Driver;