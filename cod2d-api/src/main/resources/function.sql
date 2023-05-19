create or replace function public.alpha_numeric4() returns text
    language plpgsql
as
$$
DECLARE
    current_value INTEGER;
    alphabet TEXT;
BEGIN
    current_value := nextval('alpha_numeric4_seq');
    alphabet := 'abcdefghijklmnopqrstuvwxyz0123456789'; --36
    RETURN substring(alphabet, (current_value % 36) + 1, 1) ||
           substring(alphabet, ((current_value / 36) % 36) + 1, 1) ||
           substring(alphabet, ((current_value / (36*36)) % 36) + 1, 1) ||
           substring(alphabet, ((current_value / (36*36*36)) % 36) + 1, 1);
END;
$$;

alter function public.alpha_numeric4() owner to postgres;

grant execute on function public.alpha_numeric4() to anon;

grant execute on function public.alpha_numeric4() to authenticated;

grant execute on function public.alpha_numeric4() to service_role;

