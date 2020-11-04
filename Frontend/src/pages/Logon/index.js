import React, {useState} from 'react';
import {Link, useHistory} from 'react-router-dom';
import {FiLogIn} from 'react-icons/fi';

import './styles.css';
import eventoImg from '../../assets/evento.png';
import api from '../../services/api';

export default function Logon() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const history = useHistory();

  async function handleLogin(e){
    e.preventDefault();

    try{
        const response = await api.post('usuarios', {
          email: email, 
          senha: senha
        });
        localStorage.setItem('usuarioNome',response.data.nome);
        localStorage.setItem('usuarioId',response.data.id);
        history.push('/profile');

    } catch (err){
        alert('Falha no Login, tente novamente');
    }
  }


  return (
       <div className="logon-container">
         <section className="form">
           
          <form onSubmit={handleLogin}>

            <h1>Faça seu Logon </h1>

            <input 
              placeholder=" Email"
              value={email}
              onChange ={e => setEmail(e.target.value)}
            />
            <input 
              placeholder=" Senha"
              value={senha}
              onChange ={e => setSenha(e.target.value)}
            />

            <button className="button" type="submit">Entrar</button>

            <Link className="back-link" to="/register">
              <FiLogIn size={16} color="#2E8B57"/>
              Não Tenho Cadastro
            </Link>
          </form>


         </section>
         <img src={eventoImg} alt="Evento"/>
       </div>

  );
}


