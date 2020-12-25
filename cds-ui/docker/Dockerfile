FROM hub.iquantex.com/base/nginx:1.16-alpine
LABEL maintained="jackshen"

COPY . /usr/share/nginx/html/

# 不覆盖全局配置，仅作为配置段引用.
COPY nginx.conf /etc/nginx/conf.d/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
