--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-09 17:22:41

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

DROP DATABASE "HRMS";
--
-- TOC entry 3027 (class 1262 OID 16563)
-- Name: HRMS; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "HRMS" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';


ALTER DATABASE "HRMS" OWNER TO postgres;

\connect "HRMS"

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

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 3027
-- Name: DATABASE "HRMS"; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE "HRMS" IS 'Human Resource Management System';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16609)
-- Name: Employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Employees" (
    "UserId" integer NOT NULL,
    "FirstName" character varying(50) NOT NULL,
    "LastName" character varying(50) NOT NULL,
    "NationalityId" character(11) NOT NULL,
    "BirthOfDate" date NOT NULL
);


ALTER TABLE public."Employees" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16619)
-- Name: Employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Employers" (
    "UserId" integer NOT NULL,
    "CompanyName" character varying(100) NOT NULL,
    "Phone" character(12) NOT NULL,
    "VerifiedBySystem" boolean NOT NULL
);


ALTER TABLE public."Employers" OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16639)
-- Name: JobPositions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."JobPositions" (
    "Id" integer NOT NULL,
    "PositionName" character varying NOT NULL
);


ALTER TABLE public."JobPositions" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16637)
-- Name: JobPositions_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."JobPositions" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."JobPositions_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 206 (class 1259 OID 16649)
-- Name: SystemUsers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."SystemUsers" (
    "UserId" integer NOT NULL,
    "Roles" character varying NOT NULL
);


ALTER TABLE public."SystemUsers" OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16598)
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Users" (
    "Id" integer NOT NULL,
    "Email" character varying(100) NOT NULL,
    "Password" character varying NOT NULL,
    "EmailVerified" boolean DEFAULT false NOT NULL
);


ALTER TABLE public."Users" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16596)
-- Name: Users_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Users" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3017 (class 0 OID 16609)
-- Dependencies: 202
-- Data for Name: Employees; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3018 (class 0 OID 16619)
-- Dependencies: 203
-- Data for Name: Employers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3020 (class 0 OID 16639)
-- Dependencies: 205
-- Data for Name: JobPositions; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3021 (class 0 OID 16649)
-- Dependencies: 206
-- Data for Name: SystemUsers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3016 (class 0 OID 16598)
-- Dependencies: 201
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 204
-- Name: JobPositions_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."JobPositions_Id_seq"', 1, false);


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 200
-- Name: Users_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Users_Id_seq"', 1, false);


--
-- TOC entry 2873 (class 2606 OID 16608)
-- Name: Users Email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Email" UNIQUE ("Email");


--
-- TOC entry 2879 (class 2606 OID 16646)
-- Name: JobPositions Id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."JobPositions"
    ADD CONSTRAINT "Id" PRIMARY KEY ("Id");


--
-- TOC entry 2881 (class 2606 OID 16648)
-- Name: JobPositions PositionName; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."JobPositions"
    ADD CONSTRAINT "PositionName" UNIQUE ("PositionName");


--
-- TOC entry 2877 (class 2606 OID 16613)
-- Name: Employees TCKN; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employees"
    ADD CONSTRAINT "TCKN" UNIQUE ("NationalityId");


--
-- TOC entry 2875 (class 2606 OID 16606)
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY ("Id");


--
-- TOC entry 2882 (class 2606 OID 16614)
-- Name: Employees UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employees"
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public."Users"("Id");


--
-- TOC entry 2883 (class 2606 OID 16622)
-- Name: Employers UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Employers"
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public."Users"("Id");


--
-- TOC entry 2884 (class 2606 OID 16655)
-- Name: SystemUsers UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."SystemUsers"
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public."Users"("Id");


-- Completed on 2021-05-09 17:22:41

--
-- PostgreSQL database dump complete
--

