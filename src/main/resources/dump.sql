--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-05-13 00:08:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 16456)
-- Name: cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cars (
    id integer NOT NULL,
    spz character varying(100) NOT NULL,
    vin character varying(256) NOT NULL,
    farba character varying(100) NOT NULL,
    znacka character varying(50) NOT NULL,
    client_id integer NOT NULL,
    rok_vyroby integer NOT NULL
);


ALTER TABLE public.cars OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16454)
-- Name: cars_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cars_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cars_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 202
-- Name: cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cars_id_seq OWNED BY public.cars.id;


--
-- TOC entry 201 (class 1259 OID 16442)
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clients (
    id integer NOT NULL,
    meno character varying(100) NOT NULL,
    address character varying(100) NOT NULL,
    service_id integer NOT NULL
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16440)
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clients_id_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 200
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clients_id_seq OWNED BY public.clients.id;


--
-- TOC entry 205 (class 1259 OID 16485)
-- Name: records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.records (
    id integer NOT NULL,
    price numeric,
    poznamka text,
    car_id integer NOT NULL,
    date date NOT NULL,
    type integer NOT NULL
);


ALTER TABLE public.records OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16483)
-- Name: record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.record_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.record_id_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 204
-- Name: record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.record_id_seq OWNED BY public.records.id;


--
-- TOC entry 199 (class 1259 OID 16423)
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.services (
    id integer NOT NULL,
    meno character varying NOT NULL,
    owner_id integer NOT NULL
);


ALTER TABLE public.services OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16421)
-- Name: services_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.services_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.services_id_seq OWNER TO postgres;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 198
-- Name: services_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.services_id_seq OWNED BY public.services.id;


--
-- TOC entry 197 (class 1259 OID 16404)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    meno character varying(100),
    heslo character varying(100)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16402)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 196
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2715 (class 2604 OID 16459)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 16445)
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients ALTER COLUMN id SET DEFAULT nextval('public.clients_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 16488)
-- Name: records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records ALTER COLUMN id SET DEFAULT nextval('public.record_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 16426)
-- Name: services id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services ALTER COLUMN id SET DEFAULT nextval('public.services_id_seq'::regclass);


--
-- TOC entry 2712 (class 2604 OID 16407)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2725 (class 2606 OID 16464)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 16447)
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- TOC entry 2727 (class 2606 OID 16493)
-- Name: records record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT record_pkey PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 16431)
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 16409)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 1259 OID 16453)
-- Name: fki_fk_services; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_fk_services ON public.clients USING btree (service_id);


--
-- TOC entry 2731 (class 2606 OID 16499)
-- Name: records fk_car; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.records
    ADD CONSTRAINT fk_car FOREIGN KEY (car_id) REFERENCES public.cars(id);


--
-- TOC entry 2730 (class 2606 OID 16465)
-- Name: cars fk_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES public.clients(id);


--
-- TOC entry 2729 (class 2606 OID 16448)
-- Name: clients fk_services; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT fk_services FOREIGN KEY (service_id) REFERENCES public.services(id);


--
-- TOC entry 2728 (class 2606 OID 16432)
-- Name: services fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT fk_users FOREIGN KEY (owner_id) REFERENCES public.users(id);


-- Completed on 2019-05-13 00:08:59

--
-- PostgreSQL database dump complete
--

