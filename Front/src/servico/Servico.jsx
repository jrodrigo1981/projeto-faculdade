import React, {useEffect,useState} from 'react';
import './Servico.css';
import axios from 'axios';
//import { useNavigate } from "react-router-dom";
//import Button from "../../components/Button";
//import useAuth from "../../hooks/useAuth";
//import * as C from "./styles";

const Servico = () => {
  //const { signout } = useAuth();
 // const navigate = useNavigate();
 const [servico, setServico] = useState({nomeCliente: '', dataInicio: '',horaInicio: '', atendente: '', descricaoServico: '',valorServico:'', dataPagamento: ''});
 const [servicos, setServicos] = useState([]);

 useEffect(()=>{
  axios.get("http://localhost:8080/api/servico/").then(result=>{
    setServicos(result.data);
    
  });
 },[]);

 function handleChange(event){
    setServico({...servico, [event.target.name]:event.target.value});
 }

 function handleSubmit(event){
    event.preventDefault();
    console.log(servico);
    axios.post("http://localhost:8080/api/servico/inserir", servico).then(result=>{
      console.log(result);

    })
 }

  return (
    <div className="container">
      <h1>Cadastro de Servico</h1>
      <form onSubmit={handleSubmit}>
        <div className="col-6">
          <div>
            <label className="form-label">Nome do Cliente</label>
            <input onChange={handleChange} value={servico.nomeCliente} name="nomeCliente" type="text" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Atendente</label>
            <input onChange={handleChange} value={servico.atendente} name="atendente" type="text" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Data de Inicio</label>
            <input onChange={handleChange} value={servico.dataInicio} name="dataInicio" type="date" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Hora de Inicio</label>
            <input onChange={handleChange} value={servico.horaInicio} name="horaInicio" type="time" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Data de Termino</label>
            <input onChange={handleChange} value={servico.dataPagamento} name="dataPagamento" type="date" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Serviço</label>
            <input onChange={handleChange} value={servico.servico} name="descricaoServico" type="text" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Valor do Serviço</label>
            <input onChange={handleChange} value={servico.valorServico} name="valorServico" type="number" className="form-control"></input>
          </div>
          <div>
            <label className="form-label">Data de Pagamento</label>
            <input onChange={handleChange} value={servico.dataPagamento} name="dataPagamento" type="date" className="form-control"></input>
          </div>
          <br/>
          <input type="submit" className="btn btn-success" value="Cadastrar"></input>
        </div>
      </form>
      <hr/><hr/>

      <table class="table">
  <thead>
    <tr>
      
      <th scope="col">Nome</th>
      <th scope="col">Servico</th>
      <th scope="col">Dia</th>
      <th scope="col">Hora</th>
      <th scope="col">Atendente</th>
      <th scope="col">Valor</th>
    </tr>
  </thead>
  <tbody>
    {
      servicos.map(serv=>
        <tr>
          <td>{serv.nomeCliente}</td>
          <td>{serv.descricaoServico}</td>
          <td>{serv.dataInicio}</td>
          <td>{serv.horaInicio}</td>
          <td>{serv.atendente}</td>
          <td>{serv.valorServico}</td>
        </tr>
        )}
    
  </tbody>
</table>

    </div>
  );
};

export default Servico;