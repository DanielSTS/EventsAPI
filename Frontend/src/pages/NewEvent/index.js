import React,{useState} from 'react';
import './styles.css';
import logoImg from '../../assets/logo.png'
import {Link, useHistory} from 'react-router-dom';
import {FiArrowLeft} from 'react-icons/fi'
import api from '../../services/api';

export default function Register(){

    const [nome,setNome] = useState('');
    const [local,setLocal] = useState('');
    const [data,setData] = useState('');
    const [horario,setHorario] = useState('');
    const [idAdm,setIdAdm] = useState(23);

    const history = useHistory();

    async function handleRegister(e){
        e.preventDefault();
    
        const evento = {
            nome,
            local,
            data,
            horario,
            idAdm,
        };
        console.log(evento);

        try{
            const response =  await api.post('eventos', evento);
             alert(`Nome do Evento: ${response.data.nome}`);
            history.push('/');
        } catch (err){
            alert('Erro no cadastro, tente novamente');
        }
    }   
     
    return(
        <div className="register-container">
            <div className="content">
                <section>
                    <img src={logoImg} alt="Evento"/>
                    <h1>Cadastro</h1>
                    <p>
                        Faça seu cadastro, entre na plataforma e participe de eventos incríveis.
                    </p>

                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color= "#2E8B57"/>
                         Já Tenho Cadastro
                    </Link>
                </section>

                <form onSubmit ={handleRegister}>
                    <input 
                        placeholder=" Nome do Evento"
                        value={nome}
                        onChange ={e => setNome(e.target.value)}
                    />
                    <input 
                        placeholder=" Local"
                        value={local}
                        onChange ={e => setLocal(e.target.value)}
                    />
                    <input 
                        placeholder=" Data"
                        value={data}
                        onChange ={e => setData(e.target.value)}
                    />
                     <input 
                        placeholder=" Horário"
                        value={horario}
                        onChange ={e => setHorario(e.target.value)}
                    />
                    
                    <button className="button" type="submit"> Cadastrar</button>
                </form>
            </div>
        </div>
    ); 
}