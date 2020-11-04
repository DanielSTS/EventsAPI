import React, {useEffect,useState} from 'react';
import './styles.css';
import logoImg from '../../assets/logo.svg'
import {Link, useHistory} from 'react-router-dom';
import {FiPower,FiTrash2} from 'react-icons/fi';
import api from '../../services/api';

export default function Profile(){

    const [events,setEvents] = useState([]);

    const usuarioNome = localStorage.getItem('usuarioNome');
    const usuarioId = localStorage.getItem('usuarioId');
    const history = useHistory();

    useEffect(() => {
        api.get('eventos',{
            headers: {
                Authorization: usuarioId,
            }
        }).then(response => {
            setEvents(response.data);
        })
    },[usuarioId]);

    async function handleDeleteEvent(id){
        try {
            await api.delete(`eventos/${id}`,{
            headers:{
                Authorization:usuarioId,
            }
            });

            setEvents(events.filter(event => event.id !==id));
        } catch (err) {
            alert('Erro ao deletar evento, tente novamente');
        }
    }

    function handleLogout(){
        localStorage.clear();
        history.push('/');
    }


    return(
        <div className="profile-container">
            <header>
            <img src={logoImg} alt="Eventos"/>
            <span>Bem Vindo, {usuarioNome}</span>

            <Link className="button" to="/events/new">Cadastrar Novo Evento</Link>
            <button onClick={handleLogout} type="button">
                <FiPower size={18} color="#2E8B57"/>
            </button>
            </header>

            <h1>Eventos</h1>

            <ul>
                
            </ul>
        </div>
    ); 
}