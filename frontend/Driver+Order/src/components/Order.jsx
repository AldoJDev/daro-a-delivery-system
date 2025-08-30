import React, { useEffect, useState } from "react";
import "../css/Order.css";

/*  FontAwesomeIcon */
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleDown, faAngleLeft, faAngleRight, faAngleUp, faAnglesLeft, faAnglesRight } from "@fortawesome/free-solid-svg-icons";

function Order(){
    const [inputOrder, setInputOrder] = useState("");
    const [startCounter, setStartCounter] = useState(0);
    const [endCounter, setEndCounter] = useState(8);
    const [pageCounter, setPageCounter] = useState(1);

    const [dataOrders, setDataOrders] = useState([
      {
        "id": "56de8a9b-03b6-47d7-aacc-eeb73e7c3091",
        "warehouse": {
          "id": "de05cccf-d26b-44e3-aa7b-925f5879e953",
          "name": "Centro de distribuição 2",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.550519,
          "longitude": -46.633309
        },
        "customer": {
          "id": "77d71e4d-d530-4b50-80f1-28d5f5645b62",
          "name": "Ana Luiza Silva",
          "city": "São Caetano do Sul",
          "state": "São Paulo",
          "latitude": -23.6262,
          "longitude": -46.5561
        },
        "created_at": "2024-04-19T00:00:00",
        "estimated_delivery_date": "2024-04-26T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "8e025ff5-9c8e-4180-b9a2-724b6d0e506a",
        "warehouse": {
          "id": "9f0187a1-3db9-40a5-b816-9dce71d3d0f8",
          "name": "Centro de distribuição 3",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.573,
          "longitude": -46.6417
        },
        "customer": {
          "id": "b14a5ef6-50bb-4e7c-944e-6e42c5c6d9a9",
          "name": "Rafaela Oliveira",
          "city": "São Bernardo do Campo",
          "state": "São Paulo",
          "latitude": -23.6914,
          "longitude": -46.5646
        },
        "created_at": "2024-04-20T00:00:00",
        "estimated_delivery_date": "2024-04-27T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "05212a0a-f57e-4f40-8231-007eec7cf73b",
        "warehouse": {
          "id": "ddf7c88f-42e6-4db6-9093-c99851035a13",
          "name": "Centro de distribuição 1",
          "city": "Campinas",
          "state": "São Paulo",
          "latitude": 0,
          "longitude": 0
        },
        "customer": {
          "id": "5d332745-9bb9-4883-8182-068a127c2c9c",
          "name": "Igor Rodrigues Almeida",
          "city": "Salto",
          "state": "São Paulo",
          "latitude": -23.160786,
          "longitude": -47.312402
        },
        "created_at": "2024-04-18T00:00:00",
        "estimated_delivery_date": "2024-04-25T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "56de8a9b-03b6-47d7-aacc-eeb73e7c3091",
        "warehouse": {
          "id": "de05cccf-d26b-44e3-aa7b-925f5879e953",
          "name": "Centro de distribuição 2",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.550519,
          "longitude": -46.633309
        },
        "customer": {
          "id": "77d71e4d-d530-4b50-80f1-28d5f5645b62",
          "name": "Ana Luiza Silva",
          "city": "São Caetano do Sul",
          "state": "São Paulo",
          "latitude": -23.6262,
          "longitude": -46.5561
        },
        "created_at": "2024-04-19T00:00:00",
        "estimated_delivery_date": "2024-04-26T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "8e025ff5-9c8e-4180-b9a2-724b6d0e506a",
        "warehouse": {
          "id": "9f0187a1-3db9-40a5-b816-9dce71d3d0f8",
          "name": "Centro de distribuição 3",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.573,
          "longitude": -46.6417
        },
        "customer": {
          "id": "b14a5ef6-50bb-4e7c-944e-6e42c5c6d9a9",
          "name": "Rafaela Oliveira",
          "city": "São Bernardo do Campo",
          "state": "São Paulo",
          "latitude": -23.6914,
          "longitude": -46.5646
        },
        "created_at": "2024-04-20T00:00:00",
        "estimated_delivery_date": "2024-04-27T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "05212a0a-f57e-4f40-8231-007eec7cf73b",
        "warehouse": {
          "id": "ddf7c88f-42e6-4db6-9093-c99851035a13",
          "name": "Centro de distribuição 1",
          "city": "Campinas",
          "state": "São Paulo",
          "latitude": 0,
          "longitude": 0
        },
        "customer": {
          "id": "5d332745-9bb9-4883-8182-068a127c2c9c",
          "name": "Igor Rodrigues Almeida",
          "city": "Salto",
          "state": "São Paulo",
          "latitude": -23.160786,
          "longitude": -47.312402
        },
        "created_at": "2024-04-18T00:00:00",
        "estimated_delivery_date": "2024-04-25T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "56de8a9b-03b6-47d7-aacc-eeb73e7c3091",
        "warehouse": {
          "id": "de05cccf-d26b-44e3-aa7b-925f5879e953",
          "name": "Centro de distribuição 2",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.550519,
          "longitude": -46.633309
        },
        "customer": {
          "id": "77d71e4d-d530-4b50-80f1-28d5f5645b62",
          "name": "Ana Luiza Silva",
          "city": "São Caetano do Sul",
          "state": "São Paulo",
          "latitude": -23.6262,
          "longitude": -46.5561
        },
        "created_at": "2024-04-19T00:00:00",
        "estimated_delivery_date": "2024-04-26T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "8e025ff5-9c8e-4180-b9a2-724b6d0e506a",
        "warehouse": {
          "id": "9f0187a1-3db9-40a5-b816-9dce71d3d0f8",
          "name": "Centro de distribuição 3",
          "city": "São Paulo",
          "state": "São Paulo",
          "latitude": -23.573,
          "longitude": -46.6417
        },
        "customer": {
          "id": "b14a5ef6-50bb-4e7c-944e-6e42c5c6d9a9",
          "name": "Rafaela Oliveira",
          "city": "São Bernardo do Campo",
          "state": "São Paulo",
          "latitude": -23.6914,
          "longitude": -46.5646
        },
        "created_at": "2024-04-20T00:00:00",
        "estimated_delivery_date": "2024-04-27T23:59:59",
        "status": "awaiting shipment"
      },
      {
        "id": "05212a0a-f57e-4f40-8231-007eec7cf73b",
        "warehouse": {
          "id": "ddf7c88f-42e6-4db6-9093-c99851035a13",
          "name": "Centro de distribuição 1",
          "city": "Campinas",
          "state": "São Paulo",
          "latitude": 0,
          "longitude": 0
        },
        "customer": {
          "id": "5d332745-9bb9-4883-8182-068a127c2c9c",
          "name": "Igor Rodrigues Almeida",
          "city": "Salto",
          "state": "São Paulo",
          "latitude": -23.160786,
          "longitude": -47.312402
        },
        "created_at": "2024-04-18T00:00:00",
        "estimated_delivery_date": "2024-04-25T23:59:59",
        "status": "awaiting shipment"
      },
    ]);

    const [dataOrdersBackUp] = useState(dataOrders);

    const changeInputOrder = (event) => {
        var aux = event.target.value;
        setInputOrder(aux);
    };

    const onlyDate = (dateTime) => {
        let data = new Date(dateTime);
        let date = `${data.getDate()} / ${data.getMonth() + 1} / ${data.getFullYear()}`;
        return date;
    }

    const handleWarehouseOrder = (number) => {
        let sortedOrders;

        if(number == 0){ // ordenação comum
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.warehouse.name < b.warehouse.name)
                  return -1;
                else if (a.warehouse.name > b.warehouse.name) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.warehouse.name > b.warehouse.name)
                  return -1;
                if (a.warehouse.name < b.warehouse.name) 
                  return 1;
                return 0;
              });
        }

        setDataOrders(sortedOrders);
    }

    const handleCustomerOrder = (number) => {
        let sortedOrders;

        if(number == 0){ // ordenação comum
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.customer.name < b.customer.name)
                  return -1;
                else if (a.customer.name > b.customer.name) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.customer.name > b.customer.name)
                  return -1;
                if (a.customer.name < b.customer.name) 
                  return 1;
                return 0;
              });
        }

        setDataOrders(sortedOrders);
    }

    const handleCreatedAtOrder = (number) => {
        let sortedOrders;
        
        if(number == 0){ // ordenação comum
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.created_at < b.created_at)
                  return -1;
                else if (a.created_at > b.created_at) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.created_at > b.created_at)
                  return -1;
                if (a.created_at < b.created_at) 
                  return 1;
                return 0;
              });
        }

        setDataOrders(sortedOrders);
    }

    const handleEstimatedOrder = (number) => {
        let sortedOrders;
        
        if(number == 0){ // ordenação comum
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.estimated_delivery_date < b.estimated_delivery_date)
                  return -1;
                else if (a.estimated_delivery_date > b.estimated_delivery_date) 
                  return 1;
                return 0;
              });
        }

        else{ // ordenação inversa
            sortedOrders = [...dataOrders].sort((a, b) => {
                if (a.estimated_delivery_date > b.estimated_delivery_date)
                  return -1;
                if (a.estimated_delivery_date < b.estimated_delivery_date) 
                  return 1;
                return 0;
              });
        }

        setDataOrders(sortedOrders);
    }

    /* Pagination functions */
    const handleStartOrder = () => {
      setPageCounter(1);
      setStartCounter(0);
      setEndCounter(8);
    }

    const handleEndOrder = () => {
      const pages = Math.ceil(dataOrdersBackUp.length / 8);
      const endPageIndex = (pages - 1) * 8;

      setPageCounter(pages);
      setStartCounter(endPageIndex);
      setEndCounter(dataOrdersBackUp.length);
    }

    const handlePreviousOrder = () => {
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
    
    const handleNextOrder = () => {
      const pages = Math.ceil(dataOrdersBackUp.length / 8);

      if (pageCounter < pages) { // se não está na última página
        const newStartCounter = endCounter;
        const newEndCounter = Math.min(endCounter + 8, dataOrdersBackUp.length);

        setPageCounter(pageCounter + 1);
        setStartCounter(newStartCounter);
        setEndCounter(newEndCounter);
      }
    }

    useEffect(() => {
        if(inputOrder != ""){
            const aux = dataOrdersBackUp.filter(data => data.customer.name.includes(inputOrder));
            setDataOrders(aux);
        }
        
        else{
            setDataOrders(dataOrdersBackUp);
        }
    }, [inputOrder]);

    useEffect(() => {
      const paginatedItems = dataOrdersBackUp.slice(startCounter, endCounter); // cria vetor com os 8 dados
      setDataOrders(paginatedItems);
    }, [])

    useEffect(() => {
      const paginatedItems = dataOrdersBackUp.slice(startCounter, endCounter); // cria vetor com os 8 dados
      setDataOrders(paginatedItems);
    }, [startCounter, endCounter])

    return(
        <div className="container-master-order">
            <div className="container-total-order">

                <div className="container-left-order">

                    <div className="search-order">
                        <p className="p-search-order">Buscar por nome do cliente</p>
                        <input type="text" placeholder="Buscar por nome" onChange={changeInputOrder} className="input-search-order"/>
                    </div>

                    <div className="buttons-order">
                        <button className="btn-order">Voltar</button>
                        <button className="btn-order">Criar rotas</button>
                    </div>

                </div>

                <div className="container-right-order">

                    <div className="grid-order">
                        <table className="table-order">

                            <tr className="tr-order">
                                <th className="filter-order th-order">
                                    Centro Operante
                                    <div className="icons-order">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownOrder" onClick={() => handleWarehouseOrder(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpOrder" onClick={() => handleWarehouseOrder(1)}/>
                                    </div>
                                </th>

                                <th className="filter-order th-order">
                                    Cliente
                                    <div className="icons-order">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownOrder" onClick={() => handleCustomerOrder(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpOrder" onClick={() => handleCustomerOrder(1)}/>
                                    </div>
                                </th>

                                <th className="filter-order th-order">
                                    Data do pedido
                                    <div className="icons-order">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownOrder" onClick={() => handleCreatedAtOrder(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpOrder" onClick={() => handleCreatedAtOrder(1)}/>
                                    </div>
                                </th>

                                <th className="filter-order th-order">
                                    Data estimada de entrega
                                    <div className="icons-order">
                                        <FontAwesomeIcon icon={faAngleUp} className="UpDownOrder" onClick={() => handleEstimatedOrder(0)}/>
                                        <FontAwesomeIcon icon={faAngleDown} className="DownUpOrder" onClick={() => handleEstimatedOrder(1)}/>
                                    </div>
                                </th>

                                <th className="filter-order th-order">
                                    Status
                                </th> 
                            </tr>

                            {dataOrders.map((dataOrders) => (
                                <tr className="tr-order">
                                    <td className="td-order">{dataOrders.warehouse.name}</td>
                                    <td className="td-order">{dataOrders.customer.name}</td>
                                    <td className="td-order">{onlyDate(dataOrders.created_at)}</td>
                                    <td className="td-order">{onlyDate(dataOrders.estimated_delivery_date)}</td>
                                    <td className="td-order">{dataOrders.status}</td>
                                </tr>
                            ))}

                        </table>
                    </div>

                    <div className="pagination-order">
                      <button className="pagination-button-order" onClick={handleStartOrder}>
                        <FontAwesomeIcon icon={faAnglesLeft}/>
                      </button>

                      <button className="pagination-button-order" onClick={handlePreviousOrder}>
                        <FontAwesomeIcon icon={faAngleLeft}/>
                      </button>

                      <button className="pagination-button-order" onClick={handleNextOrder}>
                        <FontAwesomeIcon icon={faAngleRight}/>
                      </button>

                      <button className="pagination-button-order" onClick={handleEndOrder}>
                        <FontAwesomeIcon icon={faAnglesRight}/>
                      </button>
                    </div>

                    <p>{pageCounter} / {Math.ceil(dataOrdersBackUp.length / 8)}</p>
                </div>

            </div>
        </div>
    );
}

export default Order;