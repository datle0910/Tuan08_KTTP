// components/TourList.jsx
const tours = [
  { id: 1, name: "Da Lat", price: 100 },
  { id: 2, name: "Phu Quoc", price: 200 },
];

export default function TourList({ onSelect }) {
  return (
    <div>
      <h2>Tour List</h2>
      {tours.map((tour) => (
        <div key={tour.id}>
          <p>
            {tour.name} - ${tour.price}
          </p>
          <button onClick={() => onSelect(tour)}>Book</button>
        </div>
      ))}
    </div>
  );
}