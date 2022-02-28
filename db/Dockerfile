FROM mcr.microsoft.com/mssql/server:2019-latest

USER root

COPY create-database.sql create-database.sql
COPY run-initialization.sh run-initialization.sh
COPY entrypoint.sh entrypoint.sh

RUN chmod +x entrypoint.sh
RUN chmod +x run-initialization.sh

CMD /bin/bash ./entrypoint.sh

RUN chmod +x entrypoint.sh

