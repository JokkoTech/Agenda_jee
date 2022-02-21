--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: event_participants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_participants (
    id integer NOT NULL,
    id_event integer NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    email character varying(255)
);


ALTER TABLE public.event_participants OWNER TO postgres;

--
-- Name: event_participants_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.event_participants_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.event_participants_id_seq OWNER TO postgres;

--
-- Name: event_participants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.event_participants_id_seq OWNED BY public.event_participants.id;


--
-- Name: events; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.events (
    eventname character varying(255) NOT NULL,
    startdate date,
    enddate date,
    starttime character varying(6),
    endtime character varying(6),
    location character varying(255),
    category character varying(255),
    priority integer,
    id integer NOT NULL
);


ALTER TABLE public.events OWNER TO postgres;

--
-- Name: events_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.events_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.events_id_seq OWNER TO postgres;

--
-- Name: events_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.events_id_seq OWNED BY public.events.id;


--
-- Name: participants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.participants (
    firstname character varying(255),
    lastname character varying(255),
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    id integer NOT NULL,
    code character varying(255) NOT NULL
);


ALTER TABLE public.participants OWNER TO postgres;

--
-- Name: participants_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.participants_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.participants_id_seq OWNER TO postgres;

--
-- Name: participants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.participants_id_seq OWNED BY public.participants.id;


--
-- Name: event_participants id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_participants ALTER COLUMN id SET DEFAULT nextval('public.event_participants_id_seq'::regclass);


--
-- Name: events id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.events ALTER COLUMN id SET DEFAULT nextval('public.events_id_seq'::regclass);


--
-- Name: participants id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.participants ALTER COLUMN id SET DEFAULT nextval('public.participants_id_seq'::regclass);


--
-- Data for Name: event_participants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event_participants (id, id_event, firstname, lastname, email) FROM stdin;
1	1	Fadel	Guiro	fadelguiro@gmail.com
2	1	Mor	Gueye	morgueye@gmail.com
3	1	Astou	Ndiaye	astoundiaye@gmail.com
4	1	Maissa	Tra	mt@gmail.com
\.


--
-- Data for Name: events; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.events (eventname, startdate, enddate, starttime, endtime, location, category, priority, id) FROM stdin;
AI	2022-02-10	2022-02-10	08:00	12:00	Amphi A	Cours	1	1
nom_2	2022-02-10	2022-02-11	09:00	12:00	CCOS	Seminaire	1	4
nom_1	2022-02-16	2022-02-16	10:00	13:00	VD	Social	1	5
\.


--
-- Data for Name: participants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.participants (firstname, lastname, email, password, id, code) FROM stdin;
Fadel	Guiro	fadelguiro@gmail.com	fadelguiro	1	Code1
\.


--
-- Name: event_participants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.event_participants_id_seq', 4, true);


--
-- Name: events_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.events_id_seq', 5, true);


--
-- Name: participants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.participants_id_seq', 1, true);


--
-- Name: event_participants event_participants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_participants
    ADD CONSTRAINT event_participants_pkey PRIMARY KEY (id);


--
-- Name: events events_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);


--
-- Name: participants participants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.participants
    ADD CONSTRAINT participants_pkey PRIMARY KEY (id);


--
-- Name: event_participants event_participants_id_event_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_participants
    ADD CONSTRAINT event_participants_id_event_fkey FOREIGN KEY (id_event) REFERENCES public.events(id);


--
-- PostgreSQL database dump complete
--

