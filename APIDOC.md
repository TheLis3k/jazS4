# API Documentation

Base URL: `http://localhost:8080`

Wszystkie błedy NBP zwracają `0` (albo `[]` dla list).

## `GET /api/exchange-rates/{code}/average`

zapytanie: `from`, `to` (`YYYY-MM-DD`):
```
GET /api/exchange-rates/usd/average?from=2024-01-01&to=2024-01-05
```
zwraca:
```json
{ "code": "USD", "from": "2024-01-01", "to": "2024-01-05", "averageMid": 3.9572 }
```
